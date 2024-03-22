package com.munihuamanga.lf_backend.services.impl;

import com.munihuamanga.lf_backend.models.dto.InspeccionDTO;
import com.munihuamanga.lf_backend.models.entities.Inspeccion;
import com.munihuamanga.lf_backend.models.entities.Solicitud;
import com.munihuamanga.lf_backend.models.mapper.InspeccionMapper;
import com.munihuamanga.lf_backend.repository.InspeccionRepository;
import com.munihuamanga.lf_backend.repository.SolicitudRepository;
import com.munihuamanga.lf_backend.services.InspeccionService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InspeccionServiceImpl implements InspeccionService {

    private final InspeccionRepository inspeccionRepository;
    private final SolicitudRepository solicitudRepository;
    private final InspeccionMapper inspeccionMapper;

    public InspeccionServiceImpl(InspeccionRepository inspeccionRepository,
                                 SolicitudRepository solicitudRepository,
                                 InspeccionMapper inspeccionMapper) {
        this.inspeccionRepository = inspeccionRepository;
        this.solicitudRepository = solicitudRepository;
        this.inspeccionMapper = inspeccionMapper;
    }

    @Override
    @Transactional
    public InspeccionDTO save(InspeccionDTO inspeccionDTO) {
        Solicitud solicicitud = solicitudRepository.findById(inspeccionDTO.getSolicitudId()).
                orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
        Inspeccion inspeccion = inspeccionMapper.toEntity(inspeccionDTO);
        inspeccion.setSolicitud(solicicitud);
        return inspeccionMapper.toDTO(inspeccionRepository.save(inspeccion));
    }

    @Override
    public InspeccionDTO findById(Long id) {
        Inspeccion inspeccion = inspeccionRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Inspeccion no encontrada"));
        return inspeccionMapper.toDTO(inspeccion);

    }

    @Override
    @Transactional(readOnly = true)
    public List<InspeccionDTO> findAll() {
        List<Inspeccion> inspecciones = inspeccionRepository.findAll();
        return inspecciones.stream().map(inspeccionMapper::toDTO).toList();
    }

    @Override
    public void delete(Long id) {
        inspeccionRepository.deleteById(id);
    }

    @Override
    public InspeccionDTO update(Long id, InspeccionDTO inspeccionDTO) {
        Optional<Inspeccion> inspeccionOptional = inspeccionRepository.findById(id);
        if (inspeccionOptional.isPresent()) {
            Inspeccion inspeccion = inspeccionOptional.get();
            inspeccion.setFechaInspeccion(inspeccionDTO.getFechaInspeccion());
            inspeccion.setObservacion(inspeccionDTO.getObservacion());
            inspeccion.setInspector(inspeccionDTO.getInspector());
            inspeccion.setResultado(inspeccionDTO.getResultado());
            inspeccion.setSolicitud(solicitudRepository.findById(inspeccionDTO.getSolicitudId())
                    .orElseThrow(() -> new RuntimeException("Solicitud no encontrada")));
            return inspeccionMapper.toDTO(inspeccionRepository.save(inspeccion));
        }
        return null;
    }
}
