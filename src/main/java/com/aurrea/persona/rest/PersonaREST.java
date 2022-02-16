package com.aurrea.persona.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.aurrea.persona.model.Persona;
import com.aurrea.persona.service.PersonaService;
import com.fasterxml.jackson.databind.util.JSONPObject;

@RestController
@RequestMapping("/api/persona")
public class PersonaREST {
	@Autowired
	private PersonaService personaServ;
	
	@GetMapping("/saludo")
	private String saludo() {
		return "Hola si sirvo";
	}
	
	@PostMapping("/agregarPersona")
	private Persona agregarPersona(@RequestBody Persona persona) {
		
		
		String url = "http://localhost:8081/api/saludo/getSaludo";
		RestTemplate restTemplate = new RestTemplate();
		String mensaje = restTemplate.getForObject(url,String.class);
		persona.setSaludo(mensaje);
		return personaServ.agregarPersona(persona);
	}
	
	@GetMapping("/findAll")
	private List<Persona> listarPersonas(){
		
		return personaServ.findAllPersonas();
	}
	
	@GetMapping("/findOne/{persona_nombre}")
	private Persona encontrarPersona(@PathVariable("persona_nombre")String persona_nombre) {
		
		return personaServ.findOnePersona(persona_nombre);
	}
	
	
}
