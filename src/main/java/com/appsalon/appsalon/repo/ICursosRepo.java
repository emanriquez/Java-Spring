package com.appsalon.appsalon.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.appsalon.appsalon.model.Cursos;

public interface ICursosRepo extends JpaRepository<Cursos, Integer> {

}
