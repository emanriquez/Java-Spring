package com.appsalon.appsalon.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.appsalon.appsalon.model.Profesores;


public interface IProfesoresService extends ICRUD<Profesores> {
	Page<Profesores> listarPageable(Pageable pageable);
}


