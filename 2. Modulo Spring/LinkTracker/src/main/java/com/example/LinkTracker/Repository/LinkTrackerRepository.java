package com.example.LinkTracker.Repository;

import com.example.LinkTracker.Entities.Link;

public interface LinkTrackerRepository {
    public void newLink(Link link);
    public boolean isLinkPresent(Link link);
    public Link findLinkById(Integer id);
    public Integer getNumbreOfRedirections(Integer id);
    public Boolean addRedirection(Integer id);
    public Boolean invalidateLink(Integer id);
}
