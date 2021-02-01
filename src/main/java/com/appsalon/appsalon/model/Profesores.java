package com.appsalon.appsalon.model;


import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "profesores")
public class Profesores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProfesor;

	
	@ManyToOne
	@JoinColumn(name = "idPersona", nullable = false, foreignKey = @ForeignKey(name = "FK_profesores_idPersona"))
	private Personas persona;
	

	@ManyToOne
	@JoinColumn(name = "id_curso", nullable = false, foreignKey = @ForeignKey(name = "FK_profesores_curso"))
	private Cursos curso;




	public Integer getIdProfesor() {
		return idProfesor;
	}




	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
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
