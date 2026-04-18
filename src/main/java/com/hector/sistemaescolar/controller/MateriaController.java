package com.hector.sistemaescolar.controller;

import com.hector.sistemaescolar.entity.Materia;
import com.hector.sistemaescolar.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    private MateriaService service;

    @GetMapping
    public List<Materia> listar() {
        return service.listar();
    }

    @PostMapping
    public Materia guardar(@RequestBody Materia materia) {
        return service.guardar(materia);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @PutMapping("/{id}")
    public Materia actualizar(@PathVariable Long id, @RequestBody Materia materia) {
        return service.actualizar(id, materia);
    }
}
