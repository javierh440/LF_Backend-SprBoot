package com.munihuamanga.lf_backend.services.impl;

import com.munihuamanga.lf_backend.models.dto.RubroNegocioDTO;
import com.munihuamanga.lf_backend.models.entities.RubroNegocio;
import com.munihuamanga.lf_backend.models.mapper.RubroNegocioMapper;
import com.munihuamanga.lf_backend.repository.RubroNegocioRepository;
import com.munihuamanga.lf_backend.services.RubroNegocioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RubroNegocioServiceImpl implements RubroNegocioService {

    private final RubroNegocioRepository rubroNegocioRepository;
    private final RubroNegocioMapper rubroNegocioMapper;

    public RubroNegocioServiceImpl(RubroNegocioRepository rubroNegocioRepository
            , RubroNegocioMapper rubroNegocioMapper) {
        this.rubroNegocioRepository = rubroNegocioRepository;
        this.rubroNegocioMapper = rubroNegocioMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<RubroNegocioDTO> findAll() {       
        return StreamSupport
                .stream(rubroNegocioRepository.findAll().spliterator(), false)
                .map(rubroNegocioMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public RubroNegocioDTO findById(Long id) {
        RubroNegocio rubroNegocio = rubroNegocioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Rubro de Negocio no encontrada"));
        return rubroNegocioMapper.toDTO(rubroNegocio);
    }

    @Override
    @Transactional
    public RubroNegocioDTO save(RubroNegocioDTO rubroNegocioDTO) {
        RubroNegocio rubroNegocio = new RubroNegocio();
        rubroNegocio.setNombre(rubroNegocioDTO.getNombre());
        return rubroNegocioMapper.toDTO(rubroNegocioRepository.save(rubroNegocio));

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        rubroNegocioRepository.deleteById(id);
    }

}
