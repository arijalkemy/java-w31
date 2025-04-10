package org.ejercicios.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Link {
    private String link;
    private int count;
    private boolean valid;
}
