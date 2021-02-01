package com.appsalon.appsalon.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.appsalon.appsalon.model.Alumno;
import com.appsalon.appsalon.repo.IAlumnoRepo;
import com.appsalon.appsalon.service.IAlumnosService;



public class AlumnoServiceImpl  implements IAlumnosService {
	
	@Autowired
	private IAlumnoRepo repo;
	
	@Override
	public Alumno registrar(Alumno alum) {
		return repo.save(alum);
	}
	
	@Override
	public Alumno modificar(Alumno alum) {
		return repo.save(alum);
	}
	
	@Override 
	public List<Alumno> listar() {
		return repo.findAll();
	}
	
	@Override
	public Page<Alumno> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	@Override
	public Alumno leerPorId(Integer id) {
		Optional<Alumno> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Alumno(); 
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}



