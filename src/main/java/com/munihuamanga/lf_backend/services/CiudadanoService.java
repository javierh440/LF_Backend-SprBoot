package com.munihuamanga.lf_backend.services;

import com.munihuamanga.lf_backend.models.dto.CiudadanoDTO;
import com.munihuamanga.lf_backend.models.entities.Ciudadano;

import java.util.List;

public interface CiudadanoService {
    List<CiudadanoDTO> findAll();
    CiudadanoDTO findById(Long id);
    CiudadanoDTO save(CiudadanoDTO ciudadanoDTO);
    CiudadanoDTO update(Long id, CiudadanoDTO ciudadanoDTO);
    void deleteById(Long id);
}
