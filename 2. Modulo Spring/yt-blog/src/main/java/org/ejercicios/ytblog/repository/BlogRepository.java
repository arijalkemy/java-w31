package org.ejercicios.ytblog.repository;

import lombok.RequiredArgsConstructor;
import org.ejercicios.ytblog.dto.BlogDTO;
import org.ejercicios.ytblog.entity.Blog;
import org.ejercicios.ytblog.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class BlogRepository {
    private HashMap<Integer, Blog> blogs;

    public BlogRepository() {
        blogs = new HashMap<>();
    }

    public boolean idAlreadyExists(int id) {
        return blogs.containsKey(id);
    }

    public void addBlog(Blog blog) {
        blogs.put(blog.getId(), blog);
    }

    public List<Blog> getAllBlogs() {
        return List.copyOf(blogs.values());
    }

    public Blog getBlog(int id) {
        return blogs.get(id);
    }
}
