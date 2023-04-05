package com.spring_postpres.repository;

import com.spring_postpres.entity.DebupMatching;
import com.spring_postpres.entity.Matching;

import java.util.List;

public interface DebupMatchingRepository {
    int insert(DebupMatching matching);
    List<DebupMatching> findByFaceId(String faceId);
    void delete(Long id);
}
