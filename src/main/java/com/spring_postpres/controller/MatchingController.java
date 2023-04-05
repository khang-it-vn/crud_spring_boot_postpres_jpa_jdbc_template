package com.spring_postpres.controller;


import com.spring_postpres.entity.Matching;
import com.spring_postpres.service.MatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/matchings")
public class MatchingController {
    @Autowired
    private MatchingService service;

    @GetMapping("")
    public List<Matching> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Matching getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("")
    public Matching create(@RequestBody Matching matching) {
        return service.save(matching);
    }

    @PutMapping("/{id}")
    public Matching update(@PathVariable Long id, @RequestBody Matching matching) {
        matching.setId(id); // ensure that the id is set
        return service.save(matching);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
