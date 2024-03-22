package com.munihuamanga.lf_backend.services;

import com.munihuamanga.lf_backend.models.dto.SolicitudDTO;

import java.util.List;

public interface SolicitudService {
    List<SolicitudDTO> findAll();
    SolicitudDTO findById(Long id);
    SolicitudDTO save(SolicitudDTO solicitudDTO);
    SolicitudDTO update(Long id, SolicitudDTO solicitudDTO);
    void delete(Long id);

}
