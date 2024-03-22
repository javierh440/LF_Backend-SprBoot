package com.munihuamanga.lf_backend.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inspeccion")
public class Inspeccion {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "solicitud_id")
  private Solicitud solicitud;
  private String fechaInspeccion;
  private String inspector;
  private String resultado;
  private String observacion;

}
