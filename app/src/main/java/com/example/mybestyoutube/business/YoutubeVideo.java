package com.example.mybestyoutube.business;

import java.io.Serializable;

public class YoutubeVideo implements Serializable {

    private long id;
    private String title;
    private String description;
    private String url;
    private String category;
    private String urlPicture;

    public YoutubeVideo() {
    }

    public YoutubeVideo(String title, String description, String url, String category, String urlPicture
    ) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.category = category;
        this.urlPicture = urlPicture;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrlPicture() {
        return urlPicture;
    }

    public void setUrlPicture(String urlPicture) {
        this.urlPicture = urlPicture;
    }

    @Override
    public String toString() {
        return "YoutubeVideo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", category='" + category + '\'' +
                ", urlPicture='" + urlPicture + '\'' +
                '}';
    }
}
