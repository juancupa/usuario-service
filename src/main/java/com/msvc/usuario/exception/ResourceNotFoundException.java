package com.msvc.usuario.exception;

public class ResourceNotFoundException  extends  RuntimeException{
    public ResourceNotFoundException() {
        super("recuros no encontrado en el servidor ");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
