package com.munihuamanga.lf_backend.services.impl;

import com.munihuamanga.lf_backend.models.dto.SolicitudDTO;
import com.munihuamanga.lf_backend.models.entities.*;
import com.munihuamanga.lf_backend.models.mapper.SolicitudMapper;
import com.munihuamanga.lf_backend.repository.CiudadanoRepository;
import com.munihuamanga.lf_backend.repository.GiroNegocioRepository;
import com.munihuamanga.lf_backend.repository.SolicitudRepository;
import com.munihuamanga.lf_backend.services.SolicitudService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    private final CiudadanoRepository ciudadanoRepository;
    private final GiroNegocioRepository giroNegocioRepository;
    private final SolicitudRepository solicitudRepository;
    private final SolicitudMapper solicitudMapper;
    SolicitudServiceImpl(SolicitudRepository solicitudRepository, SolicitudMapper solicitudMapper,
                         CiudadanoRepository ciudadanoRepository, GiroNegocioRepository giroNegocioRepository){
        this.solicitudRepository = solicitudRepository;
        this.solicitudMapper = solicitudMapper;
        this.ciudadanoRepository = ciudadanoRepository;
        this.giroNegocioRepository = giroNegocioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SolicitudDTO> findAll() {
        List<Solicitud> listSolicitud = solicitudRepository.findAll();
        return listSolicitud.stream().map(solicitudMapper::toDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public SolicitudDTO findById(Long id) {
        Solicitud solicitud = solicitudRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Solicitud no encontrada"));
        return solicitudMapper.toDTO(solicitud);
    }

    @Override
    @Transactional
    public SolicitudDTO save(SolicitudDTO solicitudDTO) {
        Ciudadano ciudadano = ciudadanoRepository.findById(solicitudDTO.getCiudadanoId())
                .orElseThrow(() -> new EntityNotFoundException("Ciudadano no encontrado"));
        GiroNegocio giroNegocio = giroNegocioRepository.findById(solicitudDTO.getGiroNegocioId())
                .orElseThrow(() -> new EntityNotFoundException("GiroNegocio no encontrado"));

        Solicitud solicitud = solicitudMapper.toEntity(solicitudDTO);
        solicitud.setCiudadano(ciudadano);
        solicitud.setGiroNegocio(giroNegocio);
        return solicitudMapper.toDTO(solicitudRepository.save(solicitud));

    }

    @Override
    @Transactional
    public SolicitudDTO update(Long id, SolicitudDTO solicitudDTO) {
        Optional<Solicitud> solicitudOptional = solicitudRepository.findById(id);
            if(solicitudOptional.isPresent()){
                Solicitud solicitud = solicitudOptional.get();
                Ciudadano ciudadano = ciudadanoRepository.findById(solicitudDTO.getCiudadanoId())
                        .orElseThrow(() -> new EntityNotFoundException("Ciudadano no encontrado"));
                GiroNegocio giroNegocio = giroNegocioRepository.findById(solicitudDTO.getGiroNegocioId())
                        .orElseThrow(() -> new EntityNotFoundException("GiroNegocio no encontrado"));
                solicitud.setCiudadano(ciudadano);
                solicitud.setGiroNegocio(giroNegocio);
                solicitud.setEstado(EstadoSolicitud.valueOf(solicitudDTO.getEstado()));
                solicitud.setFechaSolicitud(solicitudDTO.getFechaSolicitud());
                solicitud.setDescripcion(solicitudDTO.getDescripcion());
                solicitud.setFoto(solicitudDTO.getFoto());
                solicitud.setDireccion(solicitudDTO.getDireccion());
                solicitud.setObservacion(solicitudDTO.getObservacion());
                return solicitudMapper.toDTO(solicitudRepository.save(solicitud));
            }
        return null;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        solicitudRepository.deleteById(id);
    }
}
