package com.example.mybestyoutube.business;

public class YoutubeItemPlaylist {
    private String kid;
    private String etag;
    private String id;
    private YoutubeItemSnippet snippet;
    private YoutubeItemContentDetails contentDetails;

    public YoutubeItemPlaylist() {
    }

    public YoutubeItemPlaylist(String kid, String etag, String id, YoutubeItemSnippet snippet, YoutubeItemContentDetails contentDetails) {
        this.kid = kid;
        this.etag = etag;
        this.id = id;
        this.snippet = snippet;
        this.contentDetails = contentDetails;
    }

    public String getKid() {
        return kid;
    }

    public void setKid(String kid) {
        this.kid = kid;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public YoutubeItemSnippet getSnippet() {
        return snippet;
    }

    public void setSnippet(YoutubeItemSnippet snippet) {
        this.snippet = snippet;
    }

    public YoutubeItemContentDetails getContentDetails() {
        return contentDetails;
    }

    public void setContentDetails(YoutubeItemContentDetails contentDetails) {
        this.contentDetails = contentDetails;
    }

    @Override
    public String toString() {
        return "YoutubeItemPlaylist{" +
                "kid='" + kid + '\'' +
                ", etag='" + etag + '\'' +
                ", id='" + id + '\'' +
                ", snippet=" + snippet +
                ", contentDetails=" + contentDetails +
                '}';
    }
}
