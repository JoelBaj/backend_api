package com.back_api.backend_api.controller;

import com.back_api.backend_api.Util.ResponseData;
import com.back_api.backend_api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar")
    public ResponseData listar() {
        return usuarioService.findAll();
    }
    @PostMapping("/ver")
    public ResponseData detalle(@RequestBody Map<String, Integer> requestBody) {
        Integer id = requestBody.get("id");
        return usuarioService.findById(id);
    }
}