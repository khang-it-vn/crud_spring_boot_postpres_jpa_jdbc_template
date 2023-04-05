package com.spring_postpres.service;

import com.spring_postpres.entity.DebupMatching;
import com.spring_postpres.entity.DedupFaceCheck;
import com.spring_postpres.repository.DebupMatchingRepository;
import com.spring_postpres.repository.DedupFaceCheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DedupService {

    private DedupFaceCheckRepository dedupFaceCheckRepository;
    private DebupMatchingRepository matchingRepository;

    @Autowired
    public DedupService(DedupFaceCheckRepository dedupFaceCheckRepository, DebupMatchingRepository matchingRepository) {
        this.dedupFaceCheckRepository = dedupFaceCheckRepository;
        this.matchingRepository = matchingRepository;
    }

    public void createDedupFaceCheck(String faceId, boolean isChecked) {
        DedupFaceCheck dedupFaceCheck = new DedupFaceCheck(faceId, isChecked);
        dedupFaceCheckRepository.insert(dedupFaceCheck);
    }

    public void updateDedupFaceCheck(String faceId, boolean isChecked) {
        dedupFaceCheckRepository.update(faceId, isChecked);
    }

    public DedupFaceCheck getDedupFaceCheck(String faceId) {
        return dedupFaceCheckRepository.findByFaceId(faceId);
    }

    public List<DedupFaceCheck> getAllDedupFaceChecks() {
        return dedupFaceCheckRepository.findAll();
    }

    public void addMatching(String faceId, String matchingFaceId) {
        DebupMatching matching = new DebupMatching(null, faceId, matchingFaceId);
        matchingRepository.insert(matching);
    }

    public List<DebupMatching> getMatchings(String faceId) {
        return matchingRepository.findByFaceId(faceId);
    }

    public void deleteMatching(Long id) {
        matchingRepository.delete(id);
    }
}

