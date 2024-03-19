package com.munihuamanga.lf_backend.controller;

import com.munihuamanga.lf_backend.models.dto.CiudadanoDTO;
import com.munihuamanga.lf_backend.models.entities.Ciudadano;
import com.munihuamanga.lf_backend.services.CiudadanoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ciudadanos")
@CrossOrigin

public class CiudadanoController {
    private final CiudadanoService ciudadanoService;
    public CiudadanoController(CiudadanoService ciudadanoService) {
        this.ciudadanoService = ciudadanoService;
    }

    @GetMapping
    public ResponseEntity<List<CiudadanoDTO>> findAll() {

        return ResponseEntity.ok(ciudadanoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CiudadanoDTO> findById(@PathVariable Long id) {
            CiudadanoDTO ciudadanoDTO = ciudadanoService.findById(id);
        return ResponseEntity.ok(ciudadanoDTO);
    }

    @PostMapping
    public ResponseEntity<CiudadanoDTO> save(@RequestBody CiudadanoDTO ciudadanoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ciudadanoService.save(ciudadanoDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CiudadanoDTO> update(@PathVariable Long id, @RequestBody CiudadanoDTO ciudadanoDTO) {
        CiudadanoDTO ciudadanoAct = ciudadanoService.update(id, ciudadanoDTO);
        if (ciudadanoAct != null) {
            return ResponseEntity.ok(ciudadanoAct);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        ciudadanoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
