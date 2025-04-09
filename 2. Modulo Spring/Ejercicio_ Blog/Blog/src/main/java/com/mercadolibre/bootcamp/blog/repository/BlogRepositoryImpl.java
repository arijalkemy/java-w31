package com.mercadolibre.bootcamp.blog.repository;

import com.mercadolibre.bootcamp.blog.model.BlogEntry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {

    Map<Long, BlogEntry> listOfBlogs = new HashMap<>();

    {
        listOfBlogs.put(1L, new BlogEntry(1L, "To Kill a Mockingbird", "Harper Lee", "1960-07-11"));
        listOfBlogs.put(2L, new BlogEntry(2L, "1984", "George Orwell", "1949-06-08"));
        listOfBlogs.put(3L, new BlogEntry(3L, "The Great Gatsby", "F. Scott Fitzgerald", "1925-04-10"));
        listOfBlogs.put(4L, new BlogEntry(4L, "Pride and Prejudice", "Jane Austen", "1813-01-28"));
        listOfBlogs.put(5L, new BlogEntry(5L, "The Catcher in the Rye", "J.D. Salinger", "1951-07-16"));
    }


    @Override
    public BlogEntry save(BlogEntry blogEntry) {
        listOfBlogs.put(blogEntry.getId(), blogEntry);
        return listOfBlogs.get(blogEntry.getId());
    }

    @Override
    public BlogEntry getBlogEntry(Long id) {
        return listOfBlogs.get(id);
    }

    @Override
    public void updateBlogEntry(BlogEntry blogEntry) {
        if (listOfBlogs.containsKey(blogEntry.getId())) {
            listOfBlogs.put(blogEntry.getId(), blogEntry);
        }
    }

    @Override
    public void removeBlogEntry(Long id) {
        listOfBlogs.remove(id);
    }

    @Override
    public List<BlogEntry> getAllBlogEntries() {
        return new ArrayList<>(listOfBlogs.values());
    }

}
