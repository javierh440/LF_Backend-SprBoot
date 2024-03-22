package com.munihuamanga.lf_backend.repository;

import com.munihuamanga.lf_backend.models.dto.NombreDTO;
import com.munihuamanga.lf_backend.models.entities.Licencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LicenciaRepository extends JpaRepository<Licencia, Long> {
    @Query("SELECT new com.munihuamanga.lf_backend.models.dto.NombreDTO(l.solicitud.ciudadano.razonSocial, l.solicitud.direccion, l.solicitud.ciudadano.ruc, l.solicitud.giroNegocio.nombre) FROM Licencia l WHERE l.id = :licenciaId")
    NombreDTO findDetallesByLicenciaId(Long licenciaId);
}
