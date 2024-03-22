package com.munihuamanga.lf_backend.controller;

import com.munihuamanga.lf_backend.models.dto.SolicitudDTO;
import com.munihuamanga.lf_backend.models.entities.Solicitud;
import com.munihuamanga.lf_backend.services.SolicitudService;
import org.mapstruct.Mapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/solicitud")
@CrossOrigin
public class SolicitudController {

    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @GetMapping
    public ResponseEntity<List<SolicitudDTO>> findAll() {
        return ResponseEntity.ok(solicitudService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudDTO> findById(@PathVariable Long id) {
        SolicitudDTO solicitudDTO = solicitudService.findById(id);
        return ResponseEntity.ok(solicitudDTO);
    }

    @PostMapping
    public ResponseEntity<SolicitudDTO> save(@RequestBody SolicitudDTO solicitudDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitudService.save(solicitudDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolicitudDTO> update(@PathVariable Long id, @RequestBody SolicitudDTO solicitudDTO) {
        SolicitudDTO solicitudAct = solicitudService.update(id, solicitudDTO);
        if (solicitudAct != null) {
            return ResponseEntity.ok(solicitudAct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        solicitudService.delete(id);
        return ResponseEntity.ok().build();
    }

}
