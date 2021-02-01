package com.appsalon.appsalon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asignatura")



public class Asignaturas {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAsignatura;
	
	
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;


	public Integer getIdAsignatura() {
		return idAsignatura;
	}


	public void setIdAsignatura(Integer idAsignatura) {
		this.idAsignatura = idAsignatura;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
}
