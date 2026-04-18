package com.hector.sistemaescolar.repository;

import com.hector.sistemaescolar.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
