package com.appsalon.appsalon;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.appsalon.appsalon.service.IAlumnosService;


import com.appsalon.appsalon.model.Alumno;
import com.appsalon.appsalon.repo.IAlumnoRepo;



@SpringBootApplication
public class AppsalonApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppsalonApplication.class, args);
	}
	
	@Bean
	public ApplicationRunner applicationRunner(IAlumnoRepo alumnoRepo) {
		return args -> {
			prepare(alumnoRepo);
		};
	}
	
	private void prepare(IAlumnoRepo alumnoRepo) {
		/*alumnoRepo.deleteAll();
		
		Alumno alumno = new Alumno();
		alumno.setNombres("Elias");
		alumno.setApellidos("Manriquez");
		alumno.setDni("12345678");
		alumno.setEmail("springg5@gmail.com");
		alumno.setTelefono("975880872");
		alumnoRepo.save(alumno);*/
	}
	
	
	
	

}
