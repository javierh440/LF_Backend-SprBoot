package com.munihuamanga.lf_backend.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LicenciaDTO {
    private Long id;
    private Long solicitudId;
    private String estado;
    private String numero;
    private String fechaEmision;
    private String fechaVencimiento;
    private String observacion;
}
