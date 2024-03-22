package com.munihuamanga.lf_backend.controller;

import com.munihuamanga.lf_backend.models.dto.LicenciaDTO;
import com.munihuamanga.lf_backend.services.LicenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/licencias")
@CrossOrigin
public class LicenciaController {
    private final LicenciaService licenciaService;
    public LicenciaController(LicenciaService licenciaService) {
        this.licenciaService = licenciaService;
    }
    @GetMapping
    public ResponseEntity<List<LicenciaDTO>> findAll() {
        return ResponseEntity.ok(licenciaService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<LicenciaDTO> findById(@PathVariable Long id) {
        LicenciaDTO licenciaDTO = licenciaService.findById(id);
        return ResponseEntity.ok(licenciaDTO);
    }
    @PostMapping
    public ResponseEntity<LicenciaDTO> save(@RequestBody LicenciaDTO licenciaDTO) {
        return ResponseEntity.ok(licenciaService.save(licenciaDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<LicenciaDTO> update(@PathVariable Long id, @RequestBody LicenciaDTO licenciaDTO) {
        return ResponseEntity.ok(licenciaService.update(id, licenciaDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        licenciaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
