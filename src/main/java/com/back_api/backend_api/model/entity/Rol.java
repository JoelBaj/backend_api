package com.back_api.backend_api.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name="roles")
public class Rol implements Serializable {
    @Id
    @Column(name = "id_rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdRol;
    @Column(name = "rol_name")
    private String RolName;
    @OneToMany(mappedBy = "rol")
    private List<Rol_Usuario> rol_usuarios;

}
