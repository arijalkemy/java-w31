package com.meli.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLinkResponseDTO {
    private String id;
    private String link;
    private int visitorCount;
    private boolean active;
}
