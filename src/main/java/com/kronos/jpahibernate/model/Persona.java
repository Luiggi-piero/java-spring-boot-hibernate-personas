package com.kronos.jpahibernate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;

    @OneToMany
    private List<Mascota> listaMascotas;

//    @OneToOne
//    @JoinColumn(name = "una_mascota_id_mascota", referencedColumnName = "id_mascota")
//    private Mascota unaMascota;

    public Persona() {
    }

//    public Persona(Long id, String nombre, String apellido, int edad, Mascota unaMascota) {
//        this.id = id;
//        this.nombre = nombre;
//        this.apellido = apellido;
//        this.edad = edad;
//        this.unaMascota = unaMascota;
//    }

    public Persona(Long id, String nombre, String apellido, int edad, List<Mascota> listaMascotas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.listaMascotas = listaMascotas;
    }
}
