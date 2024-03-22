package com.munihuamanga.lf_backend.services;

import com.munihuamanga.lf_backend.models.dto.LicenciaDTO;

import java.util.List;

public interface LicenciaService {
    List<LicenciaDTO> findAll();
    LicenciaDTO findById(Long id);
    LicenciaDTO save(LicenciaDTO licenciaDTO);
    void delete(Long id);
    LicenciaDTO update(Long id, LicenciaDTO licenciaDTO);
    List<LicenciaDTO> findBySolicitudId(Long solicitudId);
    List<LicenciaDTO> findByEstado(String estado);
    List<LicenciaDTO> findByNumero(String numero);
}
