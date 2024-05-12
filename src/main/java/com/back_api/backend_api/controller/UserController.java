package com.back_api.backend_api.controller;

import com.back_api.backend_api.Util.ResponseData;
import com.back_api.backend_api.model.entity.Usuario;
import com.back_api.backend_api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UsuarioService usuarioService;
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listar")
    public ResponseData listar() {
        return usuarioService.findAll();
    }

}