package com.spring_postpres.service;



import com.spring_postpres.entity.Matching;

import java.util.List;

public interface MatchingService {
    List<Matching> findAll();

    Matching findById(Long id);

    Matching save(Matching matching);

    void deleteById(Long id);
}