package com.msvc.usuario.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Column(name = "id")
    private String usuariodId;
    @Column(name = "nombre", length = 20)
    private  String nombre;
    @Column(name = "email")
    private  String email;
    @Column(name = "informacion")
    private  String informacion;


    @Transient
    private List<Calificacion> calificacions = new ArrayList<>();



}
