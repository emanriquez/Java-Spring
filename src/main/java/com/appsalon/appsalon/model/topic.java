package com.appsalon.appsalon.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "topic")

public class topic {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTopic;
	
	
	@Column(name = "titulo", nullable = false, length = 50)
	private String titulo;
	
	@Column(name = "texto", nullable = false, length = 50)
	private String texto;

	
	private LocalDateTime fecha;
	
	
	@ManyToOne
	@JoinColumn(name = "id_cursoasignaturaprofesor", nullable = false, foreignKey = @ForeignKey(name = "FK_topic_cursoasigprofe"))
	private CursoProfesor cursoasignaturaprofe;


	public Integer getIdTopic() {
		return idTopic;
	}


	public void setIdTopic(Integer idTopic) {
		this.idTopic = idTopic;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}


	public LocalDateTime getFecha() {
		return fecha;
	}


	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}


	public CursoProfesor getCursoasignaturaprofe() {
		return cursoasignaturaprofe;
	}


	public void setCursoasignaturaprofe(CursoProfesor cursoasignaturaprofe) {
		this.cursoasignaturaprofe = cursoasignaturaprofe;
	}
	
	
	
	
	
	
}
