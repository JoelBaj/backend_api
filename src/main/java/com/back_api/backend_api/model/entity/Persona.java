package com.back_api.backend_api.model.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name="personas")
public class Persona implements Serializable {
    @Id
    @Column(name = "id_persona")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;

    @Column(name= "nombre", length = 60)
    private String Nombre;
    @Column(name= "apellido", length = 60)
    private String Apellido;
    @Column(name= "identificacion", length = 20)
    private String Identificacion;
    @Column(name= "fecha_nacimiento")
    private Date FechaNacimiento;

    @OneToMany(mappedBy = "persona")
    private List<Usuario> usuario;
}
