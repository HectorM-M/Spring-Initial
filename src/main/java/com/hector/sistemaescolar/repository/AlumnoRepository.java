package com.hector.sistemaescolar.repository;

import com.hector.sistemaescolar.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
