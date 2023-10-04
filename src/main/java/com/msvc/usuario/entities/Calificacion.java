package com.msvc.usuario.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Calificacion {


    private String calificacionId;
    private String usuarioId;
    private String hotelId;
    private  int calificacion;
    private String observaciones;
    private Hotel hotel;
}
