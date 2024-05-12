package com.back_api.backend_api.model.Dto;


import lombok.Data;

import java.util.List;

@Data
public class AuthResponseDTO {
    private String accessToken;
    private List<String> roles; // Agregar lista de roles u otro tipo de información adicional

    public AuthResponseDTO(String accessToken, List<String> roles) {
        this.accessToken = accessToken;
        this.roles = roles;
    }

}

