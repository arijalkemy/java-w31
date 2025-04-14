package com.example.LinkTracker.Service;

import com.example.LinkTracker.DTO.LinkDTO;
import com.example.LinkTracker.Entities.Link;

public interface LinkTrackerService {
    public LinkDTO newLink(Link link);

    public String getRedirection(Integer linkId);

    public Integer getNumberOfRedirections(Integer linkID);

    public String invalidateLink(Integer linkID);
}