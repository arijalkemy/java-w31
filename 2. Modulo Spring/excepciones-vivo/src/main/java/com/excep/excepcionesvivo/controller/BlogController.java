package com.excep.excepcionesvivo.controller;

import com.excep.excepcionesvivo.dto.BlogDTO;
import com.excep.excepcionesvivo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    @Autowired
    private IBlogService blogService;

    public ResponseEntity<Integer> saveInputBlog(@RequestBody BlogDTO blogDTO){
        return  ResponseEntity.ok(blogService.saveBlog(blogDTO));
    }
}
