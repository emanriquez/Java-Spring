package com.appsalon.appsalon.controller;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.appsalon.appsalon.exception.ModeloNotFoundException;
import com.appsalon.appsalon.model.Cursos;
import com.appsalon.appsalon.service.ICursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {
	
	//@Autowired
	private ICursoService service;
	
	@GetMapping
	public ResponseEntity<List<Cursos>> listar() {
		List<Cursos> lista = service.listar();
		return new ResponseEntity<List<Cursos>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cursos> listarPorId(@PathVariable("id") Integer id) {
		Cursos obj = service.leerPorId(id);
		if (obj.getIdCurso() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Cursos>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Cursos curso) {
		Cursos course = service.registrar(curso);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(course.getIdCurso()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Cursos> modificar(@Valid @RequestBody Cursos curso) {
		Cursos obj = service.modificar(curso);
		return new ResponseEntity<Cursos>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Cursos obj = service.leerPorId(id);
		if (obj.getIdCurso() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}
