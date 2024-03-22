package com.munihuamanga.lf_backend.services;

import com.munihuamanga.lf_backend.models.dto.CertificadoDTO;

import java.util.List;

public interface CertificadoService {
    CertificadoDTO getCertificado(Long id);
    void createCertificado(CertificadoDTO certificadoDTO);
    CertificadoDTO updateCertificado(Long id, CertificadoDTO certificadoDTO);
    void deleteCertificado(Long id);
    List<CertificadoDTO> getCertificados();

}
