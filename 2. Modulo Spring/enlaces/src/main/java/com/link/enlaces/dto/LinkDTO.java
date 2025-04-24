package com.link.enlaces.dto;

public class LinkDTO {

    private Integer linkId;
    private String link;
    private String password;
    private Integer count;

    public LinkDTO(Integer linkId, String link, String password, Integer count) {
        this.linkId = linkId;
        this.link = link;
        this.password = password;
        this.count = count;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
