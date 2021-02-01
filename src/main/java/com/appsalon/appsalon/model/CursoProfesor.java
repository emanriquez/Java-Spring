package com.appsalon.appsalon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;



@Entity
@Table(name = "cursoProfeAsignatura")
public class CursoProfesor {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCursoProfesor;
	
	
	@ManyToOne
	@JoinColumn(name = "id_profesor", nullable = false, foreignKey = @ForeignKey(name = "FK_cursoprofeasignatura_profesor"))
	private Profesores profesores;
	
	@ManyToOne
	@JoinColumn(name = "id_curso", nullable = false, foreignKey = @ForeignKey(name = "FK_cursoprofeasignatura_curso"))
	private Cursos curso;
	
	@ManyToOne
	@JoinColumn(name = "id_asignatura", nullable = false, foreignKey = @ForeignKey(name = "FK_cursoprofeasignatura_asignatura"))
	private Asignaturas asignatura;

	public Integer getIdCursoProfesor() {
		return idCursoProfesor;
	}

	public void setIdCursoProfesor(Integer idCursoProfesor) {
		this.idCursoProfesor = idCursoProfesor;
	}

	public Profesores getProfesores() {
		return profesores;
	}

	public void setProfesores(Profesores profesores) {
		this.profesores = profesores;
	}

	public Cursos getCurso() {
		return curso;
	}

	public void setCurso(Cursos curso) {
		this.curso = curso;
	}

	public Asignaturas getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignaturas asignatura) {
		this.asignatura = asignatura;
	}
	
	
	
	
}
