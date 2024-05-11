package com.back_api.backend_api.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name="sessiones")
public class Session implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha_ingreso")
    private Date FechaIngreso;
    @Column(name = "fecha_cierre")
    private Date FechaCierre;


    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
