package com.msvc.usuario.service.impl;

import com.msvc.usuario.entities.Calificacion;
import com.msvc.usuario.entities.Hotel;
import com.msvc.usuario.entities.Usuario;
import com.msvc.usuario.exception.ResourceNotFoundException;
import com.msvc.usuario.external.service.HotelService;
import com.msvc.usuario.repository.UsuarioRepository;
import com.msvc.usuario.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private  final RestTemplate restTemplate;


    private final HotelService hotelService;

    private static Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        String randomUsuarioId= UUID.randomUUID().toString();
        usuario.setUsuariodId(randomUsuarioId);
        return usuarioRepository.save(usuario);

    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return  usuarioRepository.findAll();
    }

    /*
     @Override
     /*RestTemplate*/
    /*public Usuario getUsuario(String usuarioId) {
        Usuario usuario= usuarioRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el ID :"+ usuarioId));
        //ArrayList<Calificacion>calificacionDelUsuario= restTemplate.getForObject("http://localhost:8083/calificaciones/usuarios/"+usuario.getUsuariodId(),ArrayList.class);

        Calificacion [] calificacionDelUsuario= restTemplate.getForObject("http://calificacion-service/calificaciones/usuarios/"+usuario.getUsuariodId(),Calificacion[].class);
        List<Calificacion> calificaciones = Arrays.stream(calificacionDelUsuario).collect(Collectors.toList());

        List<Calificacion> listaCalificaciones =  calificaciones.stream().map(calificacion -> {
            System.out.println(calificacion.getHotelId());
            ResponseEntity<Hotel> forEntity =  restTemplate.getForEntity("http://hotel-service/hoteles/"+calificacion.getHotelId(),Hotel.class);

            Hotel hotel=forEntity.getBody();
            logger.info("Respuesta con codigo de estado :{}", forEntity.getStatusCode());

            calificacion.setHotel(hotel);
            return  calificacion;
        }).collect(Collectors.toList());
        logger.info("{}",calificacionDelUsuario);
        usuario.setCalificacions(listaCalificaciones);
        return usuario;

    }*/


    @Override
    /*OpenFeign Client*/
    public Usuario getUsuario(String usuarioId) {
        Usuario usuario= usuarioRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el ID :"+ usuarioId));
        //ArrayList<Calificacion>calificacionDelUsuario= restTemplate.getForObject("http://localhost:8083/calificaciones/usuarios/"+usuario.getUsuariodId(),ArrayList.class);

        Calificacion [] calificacionDelUsuario= restTemplate.getForObject("http://calificacion-service/calificaciones/usuarios/"+usuario.getUsuariodId(),Calificacion[].class);
        List<Calificacion> calificaciones = Arrays.stream(calificacionDelUsuario).collect(Collectors.toList());

        List<Calificacion> listaCalificaciones =  calificaciones.stream().map(calificacion -> {
            System.out.println(calificacion.getHotelId());
         //   ResponseEntity<Hotel> forEntity =  restTemplate.getForEntity("http://hotel-service/hoteles/"+calificacion.getHotelId(),Hotel.class);

            Hotel hotel=hotelService.getHotel(calificacion.getHotelId());
           // logger.info("Respuesta con codigo de estado :{}", forEntity.getStatusCode());

            calificacion.setHotel(hotel);
            return  calificacion;
        }).collect(Collectors.toList());
        logger.info("{}",calificacionDelUsuario);
       usuario.setCalificacions(listaCalificaciones);
       return usuario;

    }

/*
    @Override
    public Usuario getUsuario(String usuarioId) {

        return  usuarioRepository.findById(usuarioId).orElseThrow(() -> new  ResourceNotFoundException("usuario o encontrado con el ID: "+usuarioId));
    }*/

}
