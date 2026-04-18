package com.hector.sistemaescolar.controller;

import com.hector.sistemaescolar.entity.Alumno;
import com.hector.sistemaescolar.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    @GetMapping
    public List<Alumno> listar() {
        return service.listar();
    }

    @PostMapping
    public Alumno guardar(@RequestBody Alumno alumno) {
        return service.guardar(alumno);
    }

    @PutMapping("/{id}")
    public Alumno actualizar(@PathVariable Long id, @RequestBody Alumno alumno) {
        return service.actualizar(id, alumno);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
