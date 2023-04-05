package com.spring_postpres.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"}, ignoreUnknown = true)
@Table(name = "HDB_DEDUP_FACE_CHECK")
public class FaceCheck {
    @Id
    @Column(name = "FACE_ID", length = 50)
    private String faceId;

    @Column(name = "IS_CHECKED")
    private boolean isChecked;


    public FaceCheck() {
    }

    public FaceCheck(String faceId, boolean isChecked) {
        this.faceId = faceId;
        this.isChecked = isChecked;
    }

    public String getFaceId() {
        return faceId;
    }

    public void setFaceId(String faceId) {
        this.faceId = faceId;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
