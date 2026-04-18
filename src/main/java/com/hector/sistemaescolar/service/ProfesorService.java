package com.hector.sistemaescolar.service;

import com.hector.sistemaescolar.entity.Profesor;
import com.hector.sistemaescolar.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository repo;

    public List<Profesor> listar() {
        return repo.findAll();
    }

    public Profesor guardar(Profesor profesor) {
        return repo.save(profesor);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
    public Profesor actualizar(Long id, Profesor profesor) {

        Profesor existente = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        existente.setNombre(profesor.getNombre());

        return repo.save(existente);
    }
    
}
