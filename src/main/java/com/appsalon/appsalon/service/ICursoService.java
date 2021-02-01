package com.appsalon.appsalon.service;


import java.util.List;
import com.appsalon.appsalon.model.Cursos;


public interface ICursoService extends ICRUD<Cursos> {
	List<Cursos> listar();
	Cursos registrar(Cursos obj);
	Cursos modificar(Cursos obj);
	Cursos leerPorId(Integer id);
	boolean eliminar(Integer id);
}


