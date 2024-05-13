package com.back_api.backend_api.model.Dto;

import lombok.Data;

@Data
public class LoginDto {
    private String username;
    private String password;
    private String mail;


}
