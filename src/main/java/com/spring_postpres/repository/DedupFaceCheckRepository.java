package com.spring_postpres.repository;

import com.spring_postpres.entity.DedupFaceCheck;

import java.util.List;

public interface DedupFaceCheckRepository {
    int insert(DedupFaceCheck dedupFaceCheck);
    int update(String faceId, boolean isChecked);
    DedupFaceCheck findByFaceId(String faceId);
    List<DedupFaceCheck> findAll();
}
