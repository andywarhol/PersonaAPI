package com.aurrea.persona.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aurrea.persona.model.Empresa;
import com.aurrea.persona.model.Persona;
import com.aurrea.persona.repository.EmpresaRepo;
import com.aurrea.persona.repository.PersonaRepository;

@Service
public class PersonaService {
	
	@Autowired
	private PersonaRepository personaRepo;
	private EmpresaRepo empresaRepo;
	public Persona agregarPersona(Persona persona) {
		Empresa empresa = new Empresa();
		empresa.setEmpresa(persona.getPersona_empresa());
		empresa.setEmpresadireccion(persona.getPersona_empresadireccion());
		return personaRepo.save(persona);
	}
	
	public List<Persona> findAllPersonas(){
		if(personaRepo.findAll().isEmpty()) {
			throw new IllegalStateException();
		}
		return personaRepo.findAll();
		
	}
	
	public Persona findOnePersona(String persona_nombre){
		if(personaRepo.getByName(persona_nombre).equals(null)) {
			throw new NullPointerException();
		}
		
		return personaRepo.getByName(persona_nombre);
	}
	
	        
	
	
}
