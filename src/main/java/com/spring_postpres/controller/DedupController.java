package com.spring_postpres.controller;

import com.spring_postpres.entity.DebupMatching;
import com.spring_postpres.entity.DedupFaceCheck;
import com.spring_postpres.service.DedupService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;

import java.io.IOException;
import java.util.List;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class DedupController {

    private static final Logger logger = Logger.getLogger(DedupController.class);
    private static final String LOG_FILE_PATH = "D:\\HdBank\\base\\spring-boot-jpa-postgresql\\logs\\";
    private final DedupService dedupService;

    @Autowired
    public DedupController(DedupService dedupService) {
        this.dedupService = dedupService;
        try {
            FileAppender fileAppender = new FileAppender(new PatternLayout(), LOG_FILE_PATH);
            logger.addAppender(fileAppender);
        } catch (IOException e) {
            logger.error("Error creating file appender", e);
        }
    }

    /**
     * Create a new DedupFaceCheck
     * @param faceCheck the DedupFaceCheck to be created
     * @return ResponseEntity with status code 201 if successful, or an error message if not
     */
    @PostMapping("/face-checks")
    public ResponseEntity<?> createDedupFaceCheck(@RequestBody DedupFaceCheck faceCheck) {
        try {
            dedupService.createDedupFaceCheck(faceCheck.getFaceId(), faceCheck.isChecked());
            logger.info("Created DedupFaceCheck with ID: " + faceCheck.getFaceId());
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating DedupFaceCheck");
        }
    }

    /**
     * Update an existing DedupFaceCheck
     * @param faceId the ID of the DedupFaceCheck to be updated
     * @param faceCheck the updated DedupFaceCheck object
     * @return ResponseEntity with status code 200 if successful, or an error message if not
     */
    @PutMapping("/face-checks/{faceId}")
    public ResponseEntity<?> updateDedupFaceCheck(@PathVariable String faceId, @RequestBody DedupFaceCheck faceCheck) {
        try {
            dedupService.updateDedupFaceCheck(faceId, faceCheck.isChecked());
            logger.info("Updated DedupFaceCheck with ID: " + faceId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating DedupFaceCheck");
        }
    }

    /**
     * Get a DedupFaceCheck by ID
     * @param faceId the ID of the DedupFaceCheck to retrieve
     * @return ResponseEntity with the DedupFaceCheck object if found, or an error message if not
     */
    @GetMapping("/face-checks/{faceId}")
    public ResponseEntity<DedupFaceCheck> getDedupFaceCheck(@PathVariable String faceId) {
        try {
            DedupFaceCheck faceCheck = dedupService.getDedupFaceCheck(faceId);
            logger.info("Retrieved DedupFaceCheck with ID: " + faceId);
            return ResponseEntity.ok().body(faceCheck);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Get all DedupFaceChecks
     * @return ResponseEntity with a list of all DedupFaceChecks
     */
    @GetMapping("/face-checks")
    public ResponseEntity<List<DedupFaceCheck>> getAllDedupFaceChecks() {
        List<DedupFaceCheck> faceChecks = dedupService.getAllDedupFaceChecks();
        logger.info("Retrieved all DedupFaceChecks");
        return ResponseEntity.ok().body(faceChecks);
    }

    /**
     * Add a new DebupMatching
     * @param matching the DebupMatching to be added
     * @return ResponseEntity with status code 201 if successful, or an error message if not
     */
    @PostMapping("/matchings")
    public ResponseEntity<?> addMatching(@RequestBody DebupMatching matching) {
        try {
            dedupService.addMatching(matching.getFaceId(), matching.getMatchingFaceId());
            logger.info("Created DebupMatching with face ID: " + matching.getFaceId() + " and matching face ID: " + matching.getMatchingFaceId());
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating DebupMatching");
        }
    }

    /**
     * Get all DebupMatchings for a given face ID
     * @param faceId the ID of the face to retrieve matchings for
     * @return ResponseEntity with a list of all DebupMatchings for the given face ID
     */
    @GetMapping("/matchings/{faceId}")
    public ResponseEntity<List<DebupMatching>> getMatchings(@PathVariable String faceId) {
        try {
            List<DebupMatching> matchings = dedupService.getMatchings(faceId);
            logger.info("Retrieved all DebupMatchings for face ID: " + faceId);
            return ResponseEntity.ok().body(matchings);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete a DebupMatching by ID
     * @param id the ID of the DebupMatching to be deleted
     * @return ResponseEntity with status code 200 if successful, or an error message if not
     */
    @DeleteMapping("/matchings/{id}")
    public ResponseEntity<?> deleteMatching(@PathVariable Long id) {
        try {
            dedupService.deleteMatching(id);
            logger.info("Deleted DebupMatching with ID: " + id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting DebupMatching");
        }
    }
}

