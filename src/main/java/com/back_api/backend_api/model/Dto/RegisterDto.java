package com.back_api.backend_api.model.Dto;

import com.back_api.backend_api.model.entity.Rol;
import lombok.Data;

import java.util.List;

@Data
public class RegisterDto {
    private String username;
    private String password;
    private String role;
}
