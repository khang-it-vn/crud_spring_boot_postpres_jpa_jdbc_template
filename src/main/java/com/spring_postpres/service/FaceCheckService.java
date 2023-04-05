package com.spring_postpres.service;


import com.spring_postpres.entity.FaceCheck;

import java.util.List;

public interface FaceCheckService {
    List<FaceCheck> findAll();

    FaceCheck findById(String id);

    FaceCheck save(FaceCheck faceCheck);

    void deleteById(String id);
}