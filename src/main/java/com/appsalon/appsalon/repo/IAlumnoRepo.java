package com.appsalon.appsalon.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.appsalon.appsalon.model.Alumno;

public interface IAlumnoRepo extends JpaRepository<Alumno, Integer> {

}
