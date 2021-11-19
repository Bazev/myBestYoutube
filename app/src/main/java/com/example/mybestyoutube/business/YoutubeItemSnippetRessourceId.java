package com.example.mybestyoutube.business;

public class YoutubeItemSnippetRessourceId {
    private String kind;
    private String videoId;

    public YoutubeItemSnippetRessourceId() {
    }

    public YoutubeItemSnippetRessourceId(String kind, String videoId) {
        this.kind = kind;
        this.videoId = videoId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @Override
    public String toString() {
        return "YoutubeItemSnippetRessourceId{" +
                "kind='" + kind + '\'' +
                ", videoId='" + videoId + '\'' +
                '}';
    }
}
