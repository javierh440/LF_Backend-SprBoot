package com.munihuamanga.lf_backend.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "licencia")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Licencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private String fechaEmision;
    private String fechaVencimiento;
    private EstadoLicencia estado;
    private String observacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solicitud_id")
    private Solicitud solicitud;
}
