package com.bootcamp.ejercicio_linktracker.repository;

import com.bootcamp.ejercicio_linktracker.model.Link;

public interface ILinkRepository {
    Integer saveLink(Link link);
    Integer getVisitCount(Integer linkId);

    Link getLinkById(Integer linkId);
    Link getRedirect(Integer linkId, String password);
}
