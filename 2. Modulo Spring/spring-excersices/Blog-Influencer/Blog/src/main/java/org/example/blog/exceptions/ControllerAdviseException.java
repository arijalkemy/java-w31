package org.example.blog.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviseException {

    @ExceptionHandler(DuplicateIdBlog.class)
    public ResponseEntity<?> DuplicateIdBlog(Exception e) {
        return ResponseEntity.status(409).body(e.getMessage());
    }
}
