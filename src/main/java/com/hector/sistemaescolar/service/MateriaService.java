package com.hector.sistemaescolar.service;

import com.hector.sistemaescolar.entity.Materia;
import com.hector.sistemaescolar.entity.Profesor;
import com.hector.sistemaescolar.repository.MateriaRepository;
import com.hector.sistemaescolar.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository repo;

    @Autowired
    private ProfesorRepository profesorRepository;

    // GET
    public List<Materia> listar() {
        return repo.findAll();
    }

    // POST
    public Materia guardar(Materia materia) {

        // Validación para evitar null
        if (materia.getProfesor() == null || materia.getProfesor().getId() == null) {
            throw new RuntimeException("Debe enviar el id del profesor");
        }

        Long profesorId = materia.getProfesor().getId();

        // Buscar profesor en BD
        Profesor profesor = profesorRepository.findById(profesorId)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        // Asignar correctamente
        materia.setProfesor(profesor);

        return repo.save(materia);
    }

    // DELETE
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    // PUT
    public Materia actualizar(Long id, Materia materia) {

        Materia existente = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        existente.setNombre(materia.getNombre());

        if (materia.getProfesor() == null || materia.getProfesor().getId() == null) {
            throw new RuntimeException("Debe enviar el id del profesor");
        }

        Long profesorId = materia.getProfesor().getId();

        Profesor profesor = profesorRepository.findById(profesorId)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        existente.setProfesor(profesor);

        return repo.save(existente);
    }
}
