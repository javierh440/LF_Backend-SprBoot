package com.munihuamanga.lf_backend.controller;

import com.munihuamanga.lf_backend.models.dto.GiroNegocioDTO;
import com.munihuamanga.lf_backend.models.entities.GiroNegocio;
import com.munihuamanga.lf_backend.services.GiroNegocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gironegocio")
@CrossOrigin
public class GiroNegocioController {
    @Autowired
    private GiroNegocioService giroNegocioService;


    @GetMapping
    public List<GiroNegocioDTO> findAll() {
        return giroNegocioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GiroNegocioDTO> findById(@PathVariable Long id) {
        GiroNegocioDTO giroNegocioDTO = giroNegocioService.findById(id);
        return ResponseEntity.ok(giroNegocioDTO);
    }
    @PostMapping
    public ResponseEntity<GiroNegocioDTO> save(@RequestBody GiroNegocioDTO giroNegocioDTO) {
        GiroNegocioDTO nuevoGiroNegocioDTO = giroNegocioService.save(giroNegocioDTO);
        return  new ResponseEntity<>(nuevoGiroNegocioDTO, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(Long id) {
        giroNegocioService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
