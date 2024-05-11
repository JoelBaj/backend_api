package com.back_api.backend_api.model.repository;

import com.back_api.backend_api.model.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByName(String name);

}
