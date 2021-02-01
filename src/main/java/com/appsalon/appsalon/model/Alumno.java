package com.appsalon.appsalon.model;


import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;


@ApiModel(description = "Información o propiedes del alumno")
@Entity
@Table(name = "alumnos")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAlumno;
	
	@ManyToOne
	@JoinColumn(name = "idPersona", nullable = false, foreignKey = @ForeignKey(name = "FK_alumno_idPersona"))
	private Personas persona;
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_curso", nullable = false, foreignKey = @ForeignKey(name = "FK_alumno_curso"))
	private Cursos curso;



	public Integer getIdAlumno() {
		return idAlumno;
	}



	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}



	public Personas getPersona() {
		return persona;
	}



	public void setPersona(Personas persona) {
		this.persona = persona;
	}



	public Cursos getCurso() {
		return curso;
	}



	public void setCurso(Cursos curso) {
		this.curso = curso;
	}

	
	
	
	
	
	
	
}
