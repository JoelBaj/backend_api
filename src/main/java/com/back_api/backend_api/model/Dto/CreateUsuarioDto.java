package com.back_api.backend_api.model.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreateUsuarioDto {
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String mail;
    private String role;
}


