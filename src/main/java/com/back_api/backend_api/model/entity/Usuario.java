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
@Table(name="usuarios")
public class Usuario implements Serializable {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdUsuario;
    @Column(name = "username", length = 50)
    private String UserName;
    @Column(name = "password", length = 50)
    private String Password;
    @Column(name = "mail", length = 120)
    private String Mail;
    @Column(name = "sessionactive", length = 10)
    private String SessionActive;
    @Column(name = "status", length = 20)
    private String Status;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;
    @OneToMany(mappedBy = "usuario")
    private List<Session> sesiones;
}
