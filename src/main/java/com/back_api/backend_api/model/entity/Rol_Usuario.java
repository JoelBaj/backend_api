package com.back_api.backend_api.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name="rolusuarios")
public class Rol_Usuario implements Serializable {
    @Id
    @Column(name = "id_rol_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdRolUsuario;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;
}
