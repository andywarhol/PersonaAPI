package com.aurrea.persona.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name="empresa")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="empresa")
	private String empresa;
	@Column(name="empresaDireccion")
	private String empresadireccion;
	
	public Empresa() {
		
	}
	public Empresa(String empresa, String empresadireccion) {
	
		this.empresa = empresa;
		this.empresadireccion = empresadireccion;
	}
	
	
	
}
