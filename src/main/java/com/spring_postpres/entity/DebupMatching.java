package com.spring_postpres.entity;
public class DebupMatching {
    private Long id;
    private String faceId;
    private String matchingFaceId;

    public DebupMatching() {}

    public DebupMatching(Long id, String faceId, String matchingFaceId) {
        this.id = id;
        this.faceId = faceId;
        this.matchingFaceId = matchingFaceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFaceId() {
        return faceId;
    }

    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    public String getMatchingFaceId() {
        return matchingFaceId;
    }

    public void setMatchingFaceId(String matchingFaceId) {
        this.matchingFaceId = matchingFaceId;
    }
}

