package com.spring_postpres.entity;

public class DedupFaceCheck {
    private String faceId;
    private boolean isChecked;

    public DedupFaceCheck() {}

    public DedupFaceCheck(String faceId, boolean isChecked) {
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

