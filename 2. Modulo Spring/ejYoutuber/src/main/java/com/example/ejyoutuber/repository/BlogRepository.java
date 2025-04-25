package com.example.ejyoutuber.repository;


import com.example.ejyoutuber.model.BlogEntry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository  implements IBlogRepository{
    List<BlogEntry> blogEntryList = new ArrayList<>();

    @Override
    public List<BlogEntry> findAll() {
        return blogEntryList;
    }

    @Override
    public void loadBlog(BlogEntry blog) {
        blogEntryList.add(blog);
    }

    public BlogRepository(){
        loadData();
    }

    private void loadData(){
        BlogEntry blog1 = new BlogEntry("1", "Viajando", "Martin", "2020-10-11");
        BlogEntry blog2 = new BlogEntry("2", "Conociendo rusia", "Pablo", "2022-10-11");
        BlogEntry blog3 = new BlogEntry("3", "Futbol", "Andres", "2024-10-11");

        blogEntryList.add(blog1);
        blogEntryList.add(blog2);
        blogEntryList.add(blog3);
    }
}
