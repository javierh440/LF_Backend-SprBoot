package com.munihuamanga.lf_backend.services;

import com.munihuamanga.lf_backend.models.dto.RubroNegocioDTO;
import com.munihuamanga.lf_backend.models.entities.RubroNegocio;

import java.util.List;
import java.util.Optional;

public interface RubroNegocioService {
    List<RubroNegocioDTO> findAll();
    RubroNegocioDTO findById(Long id);
    RubroNegocioDTO save(RubroNegocioDTO rubroNegocioDTO);
    void deleteById(Long id);
}
