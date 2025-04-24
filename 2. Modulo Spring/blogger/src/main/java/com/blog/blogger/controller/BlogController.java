package com.blog.blogger.controller;

import com.blog.blogger.entity.EntradaBlog;
import com.blog.blogger.respository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
    BlogRepository blogRepository = new BlogRepository();

    //Crear una nueva entrada de Blog y devolver un mensaje adecuado diciendo que ha sido creada correctamente mostrando su “Id”. (URI: /blog).
    //En el caso de que ya exista una entrada de blog con ese “Id”, capturar la excepción y devolver un mensaje indicando dicha situación.
    @GetMapping("/blog")
    public ResponseEntity<?> newBlog(@RequestBody EntradaBlog nuevaEntrada){
        blogRepository.agregarEntrada(nuevaEntrada);
        return new ResponseEntity<>("entrada agregada con exito" , HttpStatus.OK);
    }

    //Devolver la información de una entrada de Blog específico, recibiendo el “Id” del mismo. (URI: /blog/{id}).
    //Si el “Id” ingresado no corresponde a ninguna entrada de Blog, indicarlo con un mensaje adecuado.
    @GetMapping("/blog/{id}")
    public ResponseEntity<?> getBlog(@PathVariable int id){
        return new ResponseEntity<>(blogRepository.mostrarEntrada(id) , HttpStatus.OK);
    }

    //Devolver el listado de todas las entradas de blogs existentes. (URI: /blogs).
    @GetMapping("/blogs")
    public ResponseEntity<?> getBlogs(){
        return new ResponseEntity<>(blogRepository.mostrarEntradas(), HttpStatus.OK);
    }

}


/*
    Se debe crear una entidad llamada “EntradaBlog” con los siguientes atributos:

    Id del blog.
    Título del blog.
    Nombre del autor.
    Fecha de publicación.

    La API debe ser capaz de:

    Crear una nueva entrada de Blog y devolver un mensaje adecuado diciendo que ha sido creada correctamente mostrando su “Id”. (URI: /blog).
    En el caso de que ya exista una entrada de blog con ese “Id”, capturar la excepción y devolver un mensaje indicando dicha situación.

    Devolver la información de una entrada de Blog específico, recibiendo el “Id” del mismo. (URI: /blog/{id}).
    Si el “Id” ingresado no corresponde a ninguna entrada de Blog, indicarlo con un mensaje adecuado.

    Devolver el listado de todas las entradas de blogs existentes. (URI: /blogs).

    Implementar las clases de excepciones personalizadas que hagan falta.

    Manejar el tratamiento de las excepciones utilizando alguno de los métodos vistos.

    Nota: Como repositorio para guardar información se puede utilizar un HashMap<Integer, Blog> o un List<Blog>.

 */