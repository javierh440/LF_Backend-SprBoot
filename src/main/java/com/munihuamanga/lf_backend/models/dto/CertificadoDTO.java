package com.munihuamanga.lf_backend.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CertificadoDTO {
    private Long id;
    private Long licenciaId;
    private String codigoQR;
    private String fechaEmision;

}
