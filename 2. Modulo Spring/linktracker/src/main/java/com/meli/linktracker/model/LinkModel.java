package com.meli.linktracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkModel {
    private String id;
    private String link;
    private int visitorCount;
    private boolean active;
    private String password;
}
