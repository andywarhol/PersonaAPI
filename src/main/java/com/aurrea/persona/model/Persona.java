package com.aurrea.persona.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name="persona")
public class Persona {
	
	@Transient
	private String saludo;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="persona_nombre", length=60, unique=true)
	private String persona_nombre;
	@Column(name="persona_edad")
	private int persona_edad;
	@Column(name="persona_direccion")
	private String persona_direccion;
	@Column(name="persona_empresa")
	private String persona_empresa;
	@Column(name="persona_empresaDireccion")
	private String persona_empresadireccion;
	
	
	public Persona() {
		
	}
	
	
	public Persona(Long id, String persona_nombre, int persona_edad, String persona_direccion, String persona_empresa,
			String persona_empresadireccion) {

		this.id = id;
		this.persona_nombre = persona_nombre;
		this.persona_edad = persona_edad;
		this.persona_direccion = persona_direccion;
		this.persona_empresa = persona_empresa;
		this.persona_empresadireccion = persona_empresadireccion;
	}
	

	
}
