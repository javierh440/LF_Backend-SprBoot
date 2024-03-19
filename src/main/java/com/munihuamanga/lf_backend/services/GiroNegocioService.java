package com.munihuamanga.lf_backend.services;

import com.munihuamanga.lf_backend.models.dto.GiroNegocioDTO;
import com.munihuamanga.lf_backend.models.entities.GiroNegocio;

import java.util.List;
import java.util.Optional;

public interface GiroNegocioService {
    List<GiroNegocioDTO> findAll();
    GiroNegocioDTO findById(Long id);
    GiroNegocioDTO save(GiroNegocioDTO giroNegocioDTO);
    void deleteById(Long id);
}
