package com.spring_postpres.service.Implementation;

import com.spring_postpres.entity.FaceCheck;
import com.spring_postpres.repository.FaceCheckRepository;
import com.spring_postpres.service.FaceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaceCheckServiceImpl implements FaceCheckService {
    @Autowired
    private FaceCheckRepository repository;

    @Override
    public List<FaceCheck> findAll() {
        return repository.findAll();
    }

    @Override
    public FaceCheck findById(String id) {
        Optional<FaceCheck> result = repository.findById(id);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Could not find face check with id: " + id);
        }
    }

    @Override
    public FaceCheck save(FaceCheck faceCheck) {
        return repository.save(faceCheck);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
