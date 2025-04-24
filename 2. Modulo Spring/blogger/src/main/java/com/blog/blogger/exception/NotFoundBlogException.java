package com.blog.blogger.exception;

public class NotFoundBlogException extends RuntimeException{

    public NotFoundBlogException(){
    }

    public NotFoundBlogException(String message){
        super(message);
    }

}
