package com.munihuamanga.lf_backend.repository;

import com.munihuamanga.lf_backend.models.entities.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
}
