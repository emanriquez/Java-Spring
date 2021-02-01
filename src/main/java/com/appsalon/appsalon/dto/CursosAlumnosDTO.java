package com.appsalon.appsalon.dto;

import org.springframework.hateoas.ResourceSupport;

import com.appsalon.appsalon.model.Cursos;
import com.appsalon.appsalon.model.Profesores;

public class CursosAlumnosDTO extends ResourceSupport {

	private Cursos cursos;
	private Profesores profesores;
	
	
}
