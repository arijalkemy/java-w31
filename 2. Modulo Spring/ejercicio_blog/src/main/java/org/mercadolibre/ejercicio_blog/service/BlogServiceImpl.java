package org.mercadolibre.ejercicio_blog.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mercadolibre.ejercicio_blog.dto.EntradaBlogDTO;
import org.mercadolibre.ejercicio_blog.entity.EntradaBlog;
import org.mercadolibre.ejercicio_blog.exceptions.BadRequestException;
import org.mercadolibre.ejercicio_blog.exceptions.ConflictException;
import org.mercadolibre.ejercicio_blog.exceptions.NotFoundException;
import org.mercadolibre.ejercicio_blog.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService{

    BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<EntradaBlogDTO> getAllBlogs() {
        return getListOfBlogs();
    }

    @Override
    public String addBlog(EntradaBlogDTO blog) {
        List<EntradaBlog> blogs = blogRepository.listAllBlogs();
        EntradaBlog newBlog;

        if(blog == null) {
            throw new BadRequestException("Hubo un error al crear el Blog");
        }

        newBlog = blogs.stream().filter(b -> b.getId() == blog.getId()).findFirst().orElse(null);

        if(newBlog != null){
            throw new ConflictException("El blog con el ID " + newBlog.getId() + " ya existe");
        }

        newBlog = new EntradaBlog();

        newBlog.setId(blog.getId());
        newBlog.setTitulo(blog.getTitulo());
        newBlog.setNombreAutor(blog.getTitulo());
        newBlog.setFechaPublicacion(blog.getFechaPublicacion());

        blogRepository.addBlog(newBlog);

        return "Se creó el blog con ID " + newBlog.getId() + " con éxito";
    }

    @Override
    public EntradaBlogDTO getBlogById(int id) {
        List<EntradaBlogDTO> listOfBlogs = getListOfBlogs();

        EntradaBlogDTO blog = listOfBlogs.stream().filter(b -> b.getId() == id).findFirst().orElse(null);

        if(blog == null) {
            throw  new NotFoundException("No se encontró el blog deseado");
        }

        return blog;
    }

    private List<EntradaBlogDTO> getListOfBlogs() {
        List<EntradaBlog> listOfBlogs = blogRepository.listAllBlogs();
        ObjectMapper mapper = new ObjectMapper();
        if(listOfBlogs.isEmpty()) {
            throw new NotFoundException("No hay una lista de Blogs creada");
        }

        return listOfBlogs.stream().map(b -> mapper.convertValue(b, EntradaBlogDTO.class))
                .collect(Collectors.toList());
    }
}
