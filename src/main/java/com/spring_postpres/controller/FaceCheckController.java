package com.spring_postpres.controller;


import com.spring_postpres.entity.FaceCheck;
import com.spring_postpres.service.FaceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/facechecks")
public class FaceCheckController {
    @Autowired
    private FaceCheckService service;

    @GetMapping("")
    public List<FaceCheck> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public FaceCheck getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping("")
    public FaceCheck create(@RequestBody FaceCheck faceCheck) {
        return service.save(faceCheck);
    }

    @PutMapping("/{id}")
    public FaceCheck update(@PathVariable String id, @RequestBody FaceCheck faceCheck) {
        faceCheck.setFaceId(id); // ensure that the id is set
        return service.save(faceCheck);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
