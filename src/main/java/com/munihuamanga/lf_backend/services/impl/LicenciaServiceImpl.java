package com.munihuamanga.lf_backend.services.impl;

import com.munihuamanga.lf_backend.models.dto.LicenciaDTO;
import com.munihuamanga.lf_backend.models.entities.EstadoLicencia;
import com.munihuamanga.lf_backend.models.entities.Licencia;
import com.munihuamanga.lf_backend.models.mapper.LicenciaMapper;
import com.munihuamanga.lf_backend.repository.LicenciaRepository;
import com.munihuamanga.lf_backend.repository.SolicitudRepository;
import com.munihuamanga.lf_backend.services.LicenciaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LicenciaServiceImpl implements LicenciaService {
    private final LicenciaRepository licenciaRepository;
    private final LicenciaMapper licenciaMapper;
    private final SolicitudRepository solicitudRepository;

    public LicenciaServiceImpl(LicenciaRepository licenciaRepository, LicenciaMapper licenciaMapper,
                               SolicitudRepository solicitudRepository) {
        this.licenciaRepository = licenciaRepository;
        this.licenciaMapper = licenciaMapper;
        this.solicitudRepository = solicitudRepository;
    }
    @Override
    @Transactional(readOnly = true)
    public List<LicenciaDTO> findAll() {
        List<Licencia> listLicencia = licenciaRepository.findAll();
        return listLicencia.stream().map(licenciaMapper::toDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public LicenciaDTO findById(Long id) {
        Licencia licencia = licenciaRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Licencia no encontrada"));
        return licenciaMapper.toDTO(licencia);
    }

    @Override
    @Transactional
    public LicenciaDTO save(LicenciaDTO licenciaDTO) {
        Licencia licencia = licenciaMapper.toEntity(licenciaDTO);
        licencia.setSolicitud(solicitudRepository.findById(licenciaDTO.getSolicitudId()).
                orElseThrow(() -> new RuntimeException("Solicitud no encontrada")));
        return licenciaMapper.toDTO(licenciaRepository.save(licencia));
    }

    @Override
    public void delete(Long id) {
        licenciaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public LicenciaDTO update(Long id, LicenciaDTO licenciaDTO) {
        Optional<Licencia> licenciaOptional = licenciaRepository.findById(id);
        if(licenciaOptional.isPresent()){
            Licencia licencia = licenciaOptional.get();
            licencia.setNumero(licenciaDTO.getNumero());
            licencia.setEstado(EstadoLicencia.valueOf(licenciaDTO.getEstado()));
            licencia.setFechaEmision(licenciaDTO.getFechaEmision());
            licencia.setFechaVencimiento(licenciaDTO.getFechaVencimiento());
            licencia.setSolicitud(solicitudRepository.findById(licencia.getId())
                    .orElseThrow(() -> new RuntimeException("Solicitud no encontrada")));
            return licenciaMapper.toDTO(licenciaRepository.save(licencia));
        }
        return null;
    }

    @Override
    public List<LicenciaDTO> findBySolicitudId(Long solicitudId) {
        return null;
    }

    @Override
    public List<LicenciaDTO> findByEstado(String estado) {
        return null;
    }

    @Override
    public List<LicenciaDTO> findByNumero(String numero) {
        return null;
    }
}
