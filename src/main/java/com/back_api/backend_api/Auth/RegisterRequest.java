package com.back_api.backend_api.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private Integer IdUsuario;
    private String UserName;
    private String Password;
    private String Mail;
    private String SessionActive;
    private String Status;
}
