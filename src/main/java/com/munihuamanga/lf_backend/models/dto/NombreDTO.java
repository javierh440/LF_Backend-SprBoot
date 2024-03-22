package com.munihuamanga.lf_backend.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter

public class NombreDTO {
    private String razonSocial;
    private String direccion;
    private String ruc;
    private String nombreGiroNegocio;
    NombreDTO(String razonSocial, String direccion, String ruc, String nombreGiroNegocio) {
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.ruc = ruc;
        this.nombreGiroNegocio = nombreGiroNegocio;
    }
}
