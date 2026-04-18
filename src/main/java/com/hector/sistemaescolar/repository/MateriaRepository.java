package com.hector.sistemaescolar.repository;

import com.hector.sistemaescolar.entity.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaRepository extends JpaRepository<Materia, Long> {
}
