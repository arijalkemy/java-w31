package com.blog.blogger.respository;

import com.blog.blogger.entity.EntradaBlog;
import com.blog.blogger.exception.BadRequestException;
import com.blog.blogger.exception.NotFoundBlogException;

import java.util.HashMap;

public class BlogRepository {

    HashMap<Integer, EntradaBlog> entradas;

    public BlogRepository(){
        entradas = new HashMap<>();
        entradas.put(1, new EntradaBlog( 1, "el libro", "fer" , "12/32/22"));

    }

    public void agregarEntrada(EntradaBlog nuevaEntrada){
        if(entradas.containsKey(nuevaEntrada.getId())){
            throw new BadRequestException("ya existe una entrada con el id: " + nuevaEntrada.getId());
        }
        entradas.put(nuevaEntrada.getId(), nuevaEntrada);
    }

    public EntradaBlog mostrarEntrada(int id){
        if(entradas.containsKey(id)){
            return entradas.get(id);
        }
        else{
            throw new NotFoundBlogException("no se encontró la entrada con el id " + id);
        }

    }

    public HashMap<Integer, EntradaBlog>  mostrarEntradas(){
        return entradas;
    }




}
