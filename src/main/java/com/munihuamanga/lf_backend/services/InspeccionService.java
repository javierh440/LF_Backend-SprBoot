package com.munihuamanga.lf_backend.services;

import com.munihuamanga.lf_backend.models.dto.InspeccionDTO;

import java.util.List;

public interface InspeccionService {
    InspeccionDTO save(InspeccionDTO inspeccionDTO);
    InspeccionDTO findById(Long id);
    List<InspeccionDTO> findAll();
    void delete(Long id);
    InspeccionDTO update(Long id, InspeccionDTO inspeccionDTO);
}
