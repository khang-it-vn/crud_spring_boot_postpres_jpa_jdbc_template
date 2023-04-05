package com.spring_postpres.controller;

import com.spring_postpres.entity.DebupMatching;
import com.spring_postpres.entity.DedupFaceCheck;
import com.spring_postpres.service.DedupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class DedupController {

    private final DedupService dedupService;

    @Autowired
    public DedupController(DedupService dedupService) {
        this.dedupService = dedupService;
    }

    // CRUD operations for DedupFaceCheck

    @PostMapping("/face-checks")
    public ResponseEntity<?> createDedupFaceCheck(@RequestBody DedupFaceCheck faceCheck) {
        dedupService.createDedupFaceCheck(faceCheck.getFaceId(), faceCheck.isChecked());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/face-checks/{faceId}")
    public ResponseEntity<?> updateDedupFaceCheck(@PathVariable String faceId, @RequestBody DedupFaceCheck faceCheck) {
        dedupService.updateDedupFaceCheck(faceId, faceCheck.isChecked());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/face-checks/{faceId}")
    public ResponseEntity<DedupFaceCheck> getDedupFaceCheck(@PathVariable String faceId) {
        DedupFaceCheck faceCheck = dedupService.getDedupFaceCheck(faceId);
        return ResponseEntity.ok().body(faceCheck);
    }

    @GetMapping("/face-checks")
    public ResponseEntity<List<DedupFaceCheck>> getAllDedupFaceChecks() {
        List<DedupFaceCheck> faceChecks = dedupService.getAllDedupFaceChecks();
        return ResponseEntity.ok().body(faceChecks);
    }

    // CRUD operations for DebupMatching

    @PostMapping("/matchings")
    public ResponseEntity<?> addMatching(@RequestBody DebupMatching matching) {
        dedupService.addMatching(matching.getFaceId(), matching.getMatchingFaceId());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/matchings/{faceId}")
    public ResponseEntity<List<DebupMatching>> getMatchings(@PathVariable String faceId) {
        List<DebupMatching> matchings = dedupService.getMatchings(faceId);
        return ResponseEntity.ok().body(matchings);
    }

    @DeleteMapping("/matchings/{id}")
    public ResponseEntity<?> deleteMatching(@PathVariable Long id) {
        dedupService.deleteMatching(id);
        return ResponseEntity.ok().build();
    }
}

