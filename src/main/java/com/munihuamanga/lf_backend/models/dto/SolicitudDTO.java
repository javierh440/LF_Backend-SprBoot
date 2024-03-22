package com.munihuamanga.lf_backend.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudDTO {
    private Long id;
    private Long ciudadanoId;
    private Long giroNegocioId;
    private String descripcion;
    private String fechaSolicitud;
    private String estado;
    private String direccion;
    private String foto;
    private String observacion;
}

