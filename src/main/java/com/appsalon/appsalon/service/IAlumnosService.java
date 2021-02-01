package com.appsalon.appsalon.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.appsalon.appsalon.model.Alumno;


public interface IAlumnosService extends ICRUD<Alumno> {
	Page<Alumno> listarPageable(Pageable pageable);
}


