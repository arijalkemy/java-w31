package com.linktracker.link.dto;

import java.io.Serializable;

public class ErrorMsgDTO implements Serializable {
    private String message;

    public ErrorMsgDTO(String message) {
        this.message = message;
    }

    public ErrorMsgDTO() {
    }

    public String getMessage() {
        return message;
    }
}
