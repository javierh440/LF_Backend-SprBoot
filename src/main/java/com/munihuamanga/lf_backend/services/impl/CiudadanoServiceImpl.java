package com.munihuamanga.lf_backend.services.impl;


import com.munihuamanga.lf_backend.models.dto.CiudadanoDTO;
import com.munihuamanga.lf_backend.models.entities.Ciudadano;
import com.munihuamanga.lf_backend.models.entities.TipoCiudadano;
import com.munihuamanga.lf_backend.models.mapper.CiudadanoMapper;
import com.munihuamanga.lf_backend.repository.CiudadanoRepository;
import com.munihuamanga.lf_backend.services.CiudadanoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CiudadanoServiceImpl implements CiudadanoService {
    private final CiudadanoRepository ciudadanoRepository;
    private final CiudadanoMapper ciudadanoMapper;
    public CiudadanoServiceImpl(CiudadanoRepository ciudadanoRepository,
                                CiudadanoMapper ciudadanoMapper) {
        this.ciudadanoRepository = ciudadanoRepository;
        this.ciudadanoMapper = ciudadanoMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CiudadanoDTO> findAll() {

        List<Ciudadano> ciudadanos = ciudadanoRepository.findAll();
        return ciudadanos.stream()
                .map(ciudadanoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CiudadanoDTO findById(Long id) {
        Ciudadano ciudadano = ciudadanoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(" Ciudadano no encontrado"));
        return ciudadanoMapper.toDTO(ciudadano);
    }

    @Override
    @Transactional
    public CiudadanoDTO save(CiudadanoDTO ciudadanoDTO) {
        Ciudadano ciudadano = ciudadanoMapper.toEntity(ciudadanoDTO);
        return ciudadanoMapper.toDTO(ciudadanoRepository.save(ciudadano));

    }

    @Override
    public CiudadanoDTO update(Long id, CiudadanoDTO ciudadanoDTO) {
        Optional<Ciudadano> ciudadanoOptional = ciudadanoRepository.findById(id);
        if (ciudadanoOptional.isPresent()) {
            Ciudadano ciudadano = ciudadanoOptional.get();
            ciudadano.setNombres(ciudadanoDTO.getNombres());
            ciudadano.setApellidos(ciudadanoDTO.getApellidos());
            ciudadano.setDni(ciudadanoDTO.getDni());
            ciudadano.setTipo(TipoCiudadano.valueOf(ciudadanoDTO.getTipo()));
            ciudadano.setTelefono(ciudadanoDTO.getTelefono());
            ciudadano.setCorreo(ciudadanoDTO.getCorreo());
            ciudadano.setRuc(ciudadanoDTO.getRuc());
            ciudadano.setRazonSocial(ciudadanoDTO.getRazonSocial());
            ciudadano.setRepresentanteLegal(ciudadanoDTO.getRepresentanteLegal());
            return ciudadanoMapper.toDTO(ciudadanoRepository.save(ciudadano));
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        ciudadanoRepository.deleteById(id);
    }
}
