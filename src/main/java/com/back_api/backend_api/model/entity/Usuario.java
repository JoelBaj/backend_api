package com.back_api.backend_api.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
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
    private Integer idusuario;

    private String username;

    @Column(name = "password", length = 60)
//    @NotBlank(message = "La contraseña no puede estar vacía")
//    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$", message = "La contraseña debe contener al menos una letra mayúscula, una minúscula, un número y un carácter especial")
//
    private String password;



    @Size(min = 8, max = 20, message = "El nombre de usuario debe tener entre 8 y 20 caracteres")
    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    @NotNull(message = "El nombre de usuario es requerido")
    @Column(name = "nombre", unique = true, length = 20)
    private String nombre;

    @Column(name= "apellido", length = 50)
    private String apellido;

    @Column(name= "identificacion", unique = true, length = 10)
    @Pattern(regexp = "\\d{10}", message = "La identificación debe tener 10 dígitos")
    private String identificacion;

    @Column(name = "mail", length = 120)
    private String mail;

    @Column(name = "sessionactive")
    private String sessionActive;

    @Column(name = "status", length = 20)
    private String status;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id_rol"))
    private List<Rol> roles = new ArrayList<>();

//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name = "id_persona")
//    private Persona persona;

    @OneToMany(mappedBy = "usuario")
    private List<Session> sesiones;

}
