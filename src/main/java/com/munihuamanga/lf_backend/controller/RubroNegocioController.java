package com.munihuamanga.lf_backend.controller;

import com.munihuamanga.lf_backend.models.dto.RubroNegocioDTO;
import com.munihuamanga.lf_backend.services.RubroNegocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rubronegocio")
@CrossOrigin
public class RubroNegocioController {
    @Autowired
    private RubroNegocioService rubroNegocioService;

    @GetMapping
    public List<RubroNegocioDTO> findAll() {
        return rubroNegocioService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<RubroNegocioDTO> findById(@PathVariable Long id) {
        RubroNegocioDTO rubroNegocioDTO = rubroNegocioService.findById(id);
        return  ResponseEntity.ok(rubroNegocioDTO);
    }
    @PostMapping
    public ResponseEntity<RubroNegocioDTO> save(@RequestBody RubroNegocioDTO rubroNegocioDTO) {
        RubroNegocioDTO nuevoRubroNegocioDTO = rubroNegocioService.save(rubroNegocioDTO);
        return  new ResponseEntity<>(nuevoRubroNegocioDTO, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        rubroNegocioService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
