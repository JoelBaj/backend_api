package com.back_api.backend_api.model.repository;

import com.back_api.backend_api.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);
    Boolean existsByUsername(String username);
}
