package com.example.ejlinkertracker.service;

import com.example.ejlinkertracker.dto.LinkDtoRequest;
import com.example.ejlinkertracker.dto.LinkIdResponseDto;
import com.example.ejlinkertracker.dto.MetricResponseDto;

import java.util.List;

public interface ILinkService {
    List<LinkDtoRequest> searchAll();
    LinkIdResponseDto addLink(LinkDtoRequest link);
    String redirect(Long linkId);
    MetricResponseDto metrics(Long linkId);
    String invalidate(Long linkId);
}
