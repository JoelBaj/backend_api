package com.back_api.backend_api.model.repository;

import com.back_api.backend_api.model.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaDao extends CrudRepository<Persona, Integer> {
}
