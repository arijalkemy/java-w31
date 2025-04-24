package com.link.enlaces.dto;

public class ResponseDTO {
     private int message;
    public ResponseDTO(int message) {
        this.message = message;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }
}
