package com.bootcamp.ej_linktracker.exception;

public class LinkNotFoundException extends RuntimeException {
    public LinkNotFoundException(int id) {
      super("No se encontro el link con id: " + id);
    }
}
