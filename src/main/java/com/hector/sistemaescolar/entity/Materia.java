package com.hector.sistemaescolar.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
public class Materia {
    @ManyToMany(mappedBy = "materias")
    @JsonIgnore
    private List<Alumno> alumnos;

    public List<Alumno> getAlumnos() {
        return alumnos;
    }
    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    // Constructor vacío
    public Materia() {}

    // GETTERS Y SETTERS 👇

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}