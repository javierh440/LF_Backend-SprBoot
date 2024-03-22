package com.munihuamanga.lf_backend.controller;

import com.munihuamanga.lf_backend.models.dto.InspeccionDTO;
import com.munihuamanga.lf_backend.services.InspeccionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inspeccion")
@CrossOrigin
public class InspeccionController {
    private final InspeccionService inspeccionService;
    public InspeccionController(InspeccionService inspeccionService) {
        this.inspeccionService = inspeccionService;
    }

    @GetMapping
    public ResponseEntity<List<InspeccionDTO>> findAll() {
        return ResponseEntity.ok(inspeccionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InspeccionDTO> findById(@PathVariable Long id) {
        InspeccionDTO inspeccionDTO = inspeccionService.findById(id);
        return ResponseEntity.ok(inspeccionDTO);
    }

    @PostMapping
    public ResponseEntity<InspeccionDTO> save(@RequestBody InspeccionDTO inspeccionDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(inspeccionService.save(inspeccionDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InspeccionDTO> update(@PathVariable Long id, @RequestBody InspeccionDTO inspeccionDTO) {
        InspeccionDTO inspeccionAct = inspeccionService.update(id, inspeccionDTO);
        if (inspeccionAct != null) {
            return ResponseEntity.ok(inspeccionAct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        inspeccionService.delete(id);
        return ResponseEntity.ok().build();
    }
}
