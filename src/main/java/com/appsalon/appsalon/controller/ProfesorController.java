package com.appsalon.appsalon.controller;

	import java.net.URI;
	import java.util.List;
	import javax.validation.Valid;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.data.domain.Page;
	import org.springframework.data.domain.Pageable;
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
	import com.appsalon.appsalon.model.Profesores;
	import com.appsalon.appsalon.service.IProfesoresService;
	import io.swagger.annotations.ApiOperation;
	import io.swagger.annotations.ApiResponse;
	import io.swagger.annotations.ApiResponses;




	@RestController
	@RequestMapping("/profesor")

	public class ProfesorController {

		
		//@Autowired
		private IProfesoresService service;
		
		
		@ApiOperation(value = "Obtener todos los profesores",
			    notes = "No necesita parametros de entrada",
			    response = List.class,
			    responseContainer = "Profesores")
		 @ApiResponses(value = {
				 @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
			      @ApiResponse(code = 404, message = "Not found, no encontrado"),
			      @ApiResponse(code = 405, message = "No se encontraron profesores en la BD"),
			      @ApiResponse(code = 200, message = "Petición OK")})
		@GetMapping
		public ResponseEntity<List<Profesores>> listar() {
			List<Profesores> lista = service.listar();
			return new ResponseEntity<List<Profesores>>(lista, HttpStatus.OK);
		}
		
		
		@GetMapping("/{id}")
		public ResponseEntity<Profesores> listarPorId(@PathVariable("id") Integer id) {
			Profesores profe = service.leerPorId(id);
			if (profe.getIdProfesor() == null) {
				return new ResponseEntity<Profesores>(new Profesores(), HttpStatus.NOT_FOUND);
			}else {
				return new ResponseEntity<Profesores>(profe, HttpStatus.OK);	
			}
		}
		
		//nivel 1
			@GetMapping("/pageable")
			public ResponseEntity<Page<Profesores>> listarPageable(Pageable pageable) {
				Page<Profesores> profe = service.listarPageable(pageable);
				return new ResponseEntity<Page<Profesores>>(profe, HttpStatus.OK);
			}
			
			// nivel 2
			@PostMapping
			public ResponseEntity<Object> registrar(@Valid @RequestBody Profesores profesor) {
				Profesores profe = service.registrar(profesor);
				URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(profe.getIdProfesor()).toUri();
				return ResponseEntity.created(location).build();
			}
			
			@PutMapping
			public ResponseEntity<Profesores> modificar(@Valid @RequestBody Profesores profesor) {
				Profesores profe = service.modificar(profesor);
				return new ResponseEntity<Profesores>(profe, HttpStatus.OK);
			}
			
			@DeleteMapping("/{id}")
			public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
				Profesores profe = service.leerPorId(id);
				if (profe.getIdProfesor() == null) {
					throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
				}
				service.eliminar(id);
				return new ResponseEntity<Object>(HttpStatus.OK);
			}
			
			
		
		
		
		
		
	}

	
	