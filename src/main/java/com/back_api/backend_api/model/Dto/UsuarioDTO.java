package com.back_api.backend_api.model.Dto;

import com.back_api.backend_api.model.entity.Persona;
import com.back_api.backend_api.model.entity.Rol;
import com.back_api.backend_api.model.entity.Session;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data
@ToString
public class UsuarioDTO {
    private Integer idUsuario;
    private String username;
    private String mail;
    private String sessionActive;
    private String status;
    private Persona persona;
    private List<Rol> roles;
    private List<Session> sesiones;

    public UsuarioDTO() {
    }

}
