package com.hector.sistemaescolar.service;

import com.hector.sistemaescolar.entity.Alumno;
import com.hector.sistemaescolar.entity.Materia;
import com.hector.sistemaescolar.repository.AlumnoRepository;
import com.hector.sistemaescolar.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository repo;

    @Autowired
    private MateriaRepository materiaRepository;

    public List<Alumno> listar() {
        return repo.findAll();
    }

    public Alumno guardar(Alumno alumno) {

        // Validar materias
        if (alumno.getMaterias() != null) {
            List<Materia> materias = alumno.getMaterias().stream()
                    .map(m -> materiaRepository.findById(m.getId())
                            .orElseThrow(() -> new RuntimeException("Materia no encontrada")))
                    .toList();

            alumno.setMaterias(materias);
        }

        return repo.save(alumno);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    public Alumno actualizar(Long id, Alumno alumno) {

        Alumno existente = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        existente.setNombre(alumno.getNombre());
        existente.setApellido(alumno.getApellido());

        if (alumno.getMaterias() != null) {
            List<Materia> materias = alumno.getMaterias().stream()
                    .map(m -> materiaRepository.findById(m.getId())
                            .orElseThrow(() -> new RuntimeException("Materia no encontrada")))
                    .toList();

            existente.setMaterias(materias);
        }

        return repo.save(existente);
    }
}
