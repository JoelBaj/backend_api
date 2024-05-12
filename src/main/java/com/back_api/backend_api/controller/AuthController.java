package com.back_api.backend_api.controller;

import com.back_api.backend_api.SecurityConfig.JWTGenerator;
import com.back_api.backend_api.model.Dto.AuthResponseDTO;
import com.back_api.backend_api.model.Dto.LoginDto;
import com.back_api.backend_api.model.Dto.RegisterDto;
import com.back_api.backend_api.model.entity.Rol;
import com.back_api.backend_api.model.entity.Usuario;
import com.back_api.backend_api.model.repository.RolRepository;
import com.back_api.backend_api.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.back_api.backend_api.SecurityConfig.CustomUserDetailsService;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
    private AuthenticationManager authenticationManager;
    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;

    private CustomUserDetailsService customUserDetailsService;


    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UsuarioRepository usuarioRepository,
                          RolRepository rolRespository, PasswordEncoder passwordEncoder,
                          JWTGenerator jwtGenerator, CustomUserDetailsService customUserDetailsService) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRespository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
        this.customUserDetailsService = customUserDetailsService;
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginDto.getUsername());
        Usuario usuario = usuarioRepository.findByUsername(loginDto.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        List<String> roles = usuario.getRoles().stream()
                .map(Rol::getName)
                .collect(Collectors.toList());

        String token = jwtGenerator.generateToken(authentication);
        AuthResponseDTO responseDTO = new AuthResponseDTO(token, roles);

        return ResponseEntity.ok(responseDTO);
    }


    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        if (usuarioRepository.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = new Usuario();
        usuario.setUsername(registerDto.getUsername());
        usuario.setPassword(passwordEncoder.encode((registerDto.getPassword())));

        // Obtener el rol seleccionado por su nombre
        Rol rol = rolRepository.findByName(registerDto.getRole())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        // Asignar el rol al usuario
        usuario.setRoles(Collections.singletonList(rol));
//        Rol roles = rolRepository.findByName("USER").get();
//        usuario.setRoles(Collections.singletonList(roles));

        usuarioRepository.save(usuario);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }
}