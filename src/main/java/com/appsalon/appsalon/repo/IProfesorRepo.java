package com.appsalon.appsalon.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.appsalon.appsalon.model.Profesores;

public interface IProfesorRepo extends JpaRepository<Profesores, Integer> {

}
