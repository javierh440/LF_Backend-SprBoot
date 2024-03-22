package com.munihuamanga.lf_backend.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InspeccionDTO {
    private Long id;
    private Long solicitudId;
    private String fechaInspeccion;
    private String inspector;
    private String resultado;
    private String observacion;
}
