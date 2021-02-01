package com.appsalon.appsalon.controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.appsalon.appsalon.model.Alumno;
import com.appsalon.appsalon.service.IAlumnosService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;




@RestController
@RequestMapping("/alumnos")

public class AlumnoController {

	
	//@Autowired
	private IAlumnosService service;
	
	
	
	
	
	@ApiOperation(value = "Obtener todos los alumnos",
		    notes = "No necesita parametros de entrada",
		    response = List.class,
		    responseContainer = "Alumnos")
	 @ApiResponses(value = {
			 @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
		      @ApiResponse(code = 404, message = "Not found, no encontrado"),
		      @ApiResponse(code = 405, message = "No se encontraron alumnos en la BD"),
		      @ApiResponse(code = 200, message = "Petición OK")})
	@GetMapping
	public ResponseEntity<List<Alumno>> listar() {
		List<Alumno> lista = service.listar();
		return new ResponseEntity<List<Alumno>>(lista, HttpStatus.OK);
	}
	
	
	@ApiOperation(value="Buscar Alumnos por ID", notes="Debe enviar parametro de ID")
	@GetMapping("/{id}")
	public ResponseEntity<Alumno> listarPorId(@PathVariable("id") Integer id) {
		Alumno alum = service.leerPorId(id);
		if (alum.getIdAlumno() == null) {
			return new ResponseEntity<Alumno>(new Alumno(), HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Alumno>(alum, HttpStatus.OK);	
		}
	}
	
	//nivel 1
		@GetMapping("/pageable")
		public ResponseEntity<Page<Alumno>> listarPageable(Pageable pageable) {
			Page<Alumno> alumno = service.listarPageable(pageable);
			return new ResponseEntity<Page<Alumno>>(alumno, HttpStatus.OK);
		}
		
		// nivel 2
		@PostMapping
		public ResponseEntity<Object> registrar(@Valid @RequestBody Alumno alumno) {
			Alumno alum = service.registrar(alumno);
			//pacientes/4
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(alum.getIdAlumno()).toUri();
			return ResponseEntity.created(location).build();
		}
		
		@PutMapping
		public ResponseEntity<Alumno> modificar(@Valid @RequestBody Alumno alumno) {
			Alumno alum = service.modificar(alumno);
			return new ResponseEntity<Alumno>(alum, HttpStatus.OK);
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
			Alumno alum = service.leerPorId(id);
			if (alum.getIdAlumno() == null) {
				throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
			}
			service.eliminar(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		
		
	
	
	
	
	
}
