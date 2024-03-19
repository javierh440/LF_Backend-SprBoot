package com.munihuamanga.lf_backend.services.impl;

import com.munihuamanga.lf_backend.models.dto.GiroNegocioDTO;
import com.munihuamanga.lf_backend.models.entities.GiroNegocio;
import com.munihuamanga.lf_backend.models.entities.RubroNegocio;
import com.munihuamanga.lf_backend.models.mapper.GiroNegocioMapper;
import com.munihuamanga.lf_backend.repository.GiroNegocioRepository;
import com.munihuamanga.lf_backend.repository.RubroNegocioRepository;
import com.munihuamanga.lf_backend.services.GiroNegocioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GiroNegocioServiceimpl implements GiroNegocioService {

    private final GiroNegocioRepository giroNegocioRepository;
    private final RubroNegocioRepository rubroNegocioRepository;
    private final GiroNegocioMapper giroNegocioMapper;

    public GiroNegocioServiceimpl(GiroNegocioRepository giroNegocioRepository,
                                  RubroNegocioRepository rubroNegocioRepository,
                                  GiroNegocioMapper giroNegocioMapper) {
        this.giroNegocioRepository = giroNegocioRepository;
        this.rubroNegocioRepository = rubroNegocioRepository;
        this.giroNegocioMapper = giroNegocioMapper;
    }
    @Override
    @Transactional(readOnly = true)
    public List<GiroNegocioDTO> findAll() {
        return StreamSupport
                .stream(giroNegocioRepository.findAll().spliterator(), false)
                .map(giroNegocioMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public GiroNegocioDTO findById(Long id) {
        GiroNegocio giroNegocio = giroNegocioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Giro de Negocio no encontrada"));
        return giroNegocioMapper.toDTO(giroNegocio);
    }

    @Override
    @Transactional
    public GiroNegocioDTO save(GiroNegocioDTO giroNegocioDTO) {
        RubroNegocio rubroNegocio = rubroNegocioRepository.findById(giroNegocioDTO.getRubroNegocioId())
                .orElseThrow(() -> new EntityNotFoundException("RubroNegocio no encontrado"));
        GiroNegocio giroNegocio = giroNegocioMapper.toEntity(giroNegocioDTO);
        giroNegocio.setRubroNegocio(rubroNegocio);
        return giroNegocioMapper.toDTO(giroNegocioRepository.save(giroNegocio));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        giroNegocioRepository.deleteById(id);
    }


}
