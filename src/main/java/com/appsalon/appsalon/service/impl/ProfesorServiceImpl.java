package com.appsalon.appsalon.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.appsalon.appsalon.model.Profesores;
import com.appsalon.appsalon.repo.IProfesorRepo;
import com.appsalon.appsalon.service.IProfesoresService;



public class ProfesorServiceImpl  implements IProfesoresService {
	
	@Autowired
	private IProfesorRepo repo;
	
	@Override
	public Profesores registrar(Profesores prof) {
		return repo.save(prof);
	}
	
	@Override
	public Profesores modificar(Profesores prof) {
		return repo.save(prof);
	}
	
	@Override 
	public List<Profesores> listar() {
		return repo.findAll();
	}
	
	@Override
	public Page<Profesores> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	@Override
	public Profesores leerPorId(Integer id) {
		Optional<Profesores> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Profesores(); 
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}



