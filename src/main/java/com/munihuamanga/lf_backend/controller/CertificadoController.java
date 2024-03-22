package com.munihuamanga.lf_backend.controller;

import com.munihuamanga.lf_backend.models.dto.CertificadoDTO;
import com.munihuamanga.lf_backend.services.CertificadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/certificado")
@CrossOrigin
public class CertificadoController {
    private final CertificadoService certificadoService;

    public CertificadoController(CertificadoService certificadoService) {
        this.certificadoService = certificadoService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CertificadoDTO certificadoDTO) {
        certificadoService.createCertificado(certificadoDTO);
        return ResponseEntity.ok().build();
    }
}
