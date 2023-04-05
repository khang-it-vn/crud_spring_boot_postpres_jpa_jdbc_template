package com.spring_postpres.service.Implementation;


import com.spring_postpres.entity.Matching;
import com.spring_postpres.repository.MatchingRepository;
import com.spring_postpres.service.MatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchingServiceImpl implements MatchingService {
    @Autowired
    private MatchingRepository repository;

    @Override
    public List<Matching> findAll() {
        return repository.findAll();
    }

    @Override
    public Matching findById(Long id) {
        Optional<Matching> result = repository.findById(id);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Could not find matching with id: " + id);
        }
    }

    @Override
    public Matching save(Matching matching) {
        return repository.save(matching);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
