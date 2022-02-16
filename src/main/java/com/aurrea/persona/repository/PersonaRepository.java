package com.aurrea.persona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aurrea.persona.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{

	@Query("From Persona where persona_nombre=:persona_nombre")
	Persona getByName(@Param("persona_nombre")String persona_nombre);
	
	
}
