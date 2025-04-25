package com.meli.linktracker.service;

import org.springframework.stereotype.Service;

import com.meli.linktracker.dto.CreateLinkRequestDTO;
import com.meli.linktracker.dto.CreateLinkResponseDTO;
import com.meli.linktracker.dto.GetLinkResponseDTO;
import com.meli.linktracker.model.LinkModel;
import com.meli.linktracker.repository.LinkRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LinkService {
    private final LinkRepository linkRepository;

    public CreateLinkResponseDTO createLink(CreateLinkRequestDTO dto) {
        LinkModel link = new LinkModel(null, dto.getLink(), 0, true,
                dto.getPassword() != null ? dto.getPassword() : "");
        return mapModelToCreateLinkResponse(linkRepository.createLink(link));
    }

    public GetLinkResponseDTO getLinkWithMetrics(String linkId) {
        LinkModel linkModel = linkRepository.getLinkById(linkId);
        return mapModelToGetLinkResponse(linkModel);
    }

    public GetLinkResponseDTO invalidateLink(String linkId) {
        LinkModel link = linkRepository.getLinkById(linkId);

        if (link == null) {
            return null;
        }

        return mapModelToGetLinkResponse(linkRepository.invalidateLinkById(linkId));

    }

    private GetLinkResponseDTO mapModelToGetLinkResponse(LinkModel link) {
        return new GetLinkResponseDTO(link.getId(), link.getLink(), link.getVisitorCount(), link.isActive());
    }

    private CreateLinkResponseDTO mapModelToCreateLinkResponse(LinkModel link) {
        return new CreateLinkResponseDTO(link.getId(), link.getLink(), link.getPassword());
    }
}
