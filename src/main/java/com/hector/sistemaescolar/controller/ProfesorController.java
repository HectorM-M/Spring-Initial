package com.hector.sistemaescolar.controller;

import com.hector.sistemaescolar.entity.Profesor;
import com.hector.sistemaescolar.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService service;

    @GetMapping
    public List<Profesor> listar() {
        return service.listar();
    }

    @PostMapping
    public Profesor guardar(@RequestBody Profesor profesor) {
        return service.guardar(profesor);
    }
    @PutMapping("/{id}")
    public Profesor actualizar(@PathVariable Long id, @RequestBody Profesor profesor) {
        return service.actualizar(id, profesor);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}