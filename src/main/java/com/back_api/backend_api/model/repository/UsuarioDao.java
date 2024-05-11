package com.back_api.backend_api.model.repository;

import com.back_api.backend_api.model.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioDao extends CrudRepository<Usuario, Integer> {

}
