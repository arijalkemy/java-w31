package com.bootcamp.ej_blog.exception;

public class BlogNotFoundException extends RuntimeException {
  public BlogNotFoundException(int id) {

    super("No se encontro una entrada de blog con el ID: "+id);
  }
}
