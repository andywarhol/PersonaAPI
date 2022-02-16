package com.aurrea.persona.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurrea.persona.model.Persona;

public interface EmpresaRepo extends JpaRepository<Persona, Long>{

}
