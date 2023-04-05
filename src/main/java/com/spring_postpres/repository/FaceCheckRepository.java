package com.spring_postpres.repository;


import com.spring_postpres.entity.FaceCheck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaceCheckRepository extends JpaRepository<FaceCheck, String> {
}