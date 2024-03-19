package com.munihuamanga.lf_backend.models.dto;

import com.munihuamanga.lf_backend.models.entities.TipoCiudadano;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CiudadanoDTO {
    private Long id;
    private String tipo;
    private String nombres;
    private String apellidos;
    private String dni;
    private String correo;
    private String telefono;
    private String ruc;
    private String razonSocial;
    private String representanteLegal;
}
