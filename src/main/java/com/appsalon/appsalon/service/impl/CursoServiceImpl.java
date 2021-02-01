package com.appsalon.appsalon.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.appsalon.appsalon.model.Cursos;
import com.appsalon.appsalon.repo.ICursosRepo;
import com.appsalon.appsalon.service.ICursoService;

@Service
public class CursoServiceImpl implements ICursoService {
	
	@Autowired
	private ICursosRepo repo;
	
	@Override
	public Cursos registrar(Cursos obj) {
		return repo.save(obj);
	}
	
	@Override
	public Cursos modificar(Cursos obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Cursos> listar() {
		return repo.findAll();
	}
	
	@Override
	public Cursos leerPorId(Integer id) {
		Optional<Cursos> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Cursos();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

	
}
