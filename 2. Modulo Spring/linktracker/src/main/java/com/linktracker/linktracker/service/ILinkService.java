package com.linktracker.linktracker.service;

import com.linktracker.linktracker.dto.LinkDTO;

public interface ILinkService {
    public LinkDTO createLink(String url, String password);
    public String getRedirectUrl(int id, String password);
    public Integer getRedirectCount(int id);
    public void invalidateLink(int id);

}
