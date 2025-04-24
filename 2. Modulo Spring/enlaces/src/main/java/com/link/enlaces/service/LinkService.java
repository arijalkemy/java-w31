package com.link.enlaces.service;

import com.link.enlaces.dto.ResponseDTO;

public interface LinkService {
    ResponseDTO addLink(String newLink);

    String redirectLink(int idLink, String password);

    ResponseDTO getMetrics(int linkID);
}
