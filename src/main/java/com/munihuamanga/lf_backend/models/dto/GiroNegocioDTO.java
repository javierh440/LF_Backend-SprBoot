package com.munihuamanga.lf_backend.models.dto;

public class GiroNegocioDTO {
    private Long id;
    private String nombre;
    private Long rubroNegocioId; // Referencia al RubroNegocio
    private String rubroNegocioNombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getRubroNegocioId() {
        return rubroNegocioId;
    }

    public void setRubroNegocioId(Long rubroNegocioId) {
        this.rubroNegocioId = rubroNegocioId;
    }

    public String getRubroNegocioNombre() {
        return rubroNegocioNombre;
    }

    public void setRubroNegocioNombre(String rubroNegocioNombre) {
        this.rubroNegocioNombre = rubroNegocioNombre;
    }
}
