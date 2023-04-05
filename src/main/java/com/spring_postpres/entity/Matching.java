package com.spring_postpres.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"}, ignoreUnknown = true)
@Table(name = "HDB_DEDUP_MATCHING")
public class Matching {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "FACE_ID", referencedColumnName = "FACE_ID")
    private FaceCheck faceCheck;

    @Column(name = "MATCHING_FACE_ID", length = 50)
    private String matchingFaceId;

    public Matching() {
    }

    public Matching(Long id, FaceCheck faceCheck, String matchingFaceId) {
        this.id = id;
        this.faceCheck = faceCheck;
        this.matchingFaceId = matchingFaceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FaceCheck getFaceCheck() {
        return faceCheck;
    }

    public void setFaceCheck(FaceCheck faceCheck) {
        this.faceCheck = faceCheck;
    }

    public String getMatchingFaceId() {
        return matchingFaceId;
    }

    public void setMatchingFaceId(String matchingFaceId) {
        this.matchingFaceId = matchingFaceId;
    }
}

