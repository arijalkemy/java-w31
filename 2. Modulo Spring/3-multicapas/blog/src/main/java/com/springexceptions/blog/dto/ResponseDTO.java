package com.springexceptions.blog.dto;

import java.io.Serializable;

public class ResponseDTO implements Serializable {
    private String data;

    public ResponseDTO(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
