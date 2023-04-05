package com.spring_postpres.repository.impl;

import com.spring_postpres.entity.DedupFaceCheck;
import com.spring_postpres.repository.DedupFaceCheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DedupFaceCheckJdbcTemplateRepository implements DedupFaceCheckRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DedupFaceCheckJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(DedupFaceCheck dedupFaceCheck) {
        String sql = "INSERT INTO HDB_DEDUP_FACE_CHECK (FACE_ID, IS_CHECKED) VALUES (?, ?)";
        return jdbcTemplate.update(sql, dedupFaceCheck.getFaceId(), dedupFaceCheck.isChecked());
    }

    @Override
    public int update(String faceId, boolean isChecked) {
        String sql = "UPDATE HDB_DEDUP_FACE_CHECK SET IS_CHECKED = ? WHERE FACE_ID = ?";
        return jdbcTemplate.update(sql, isChecked, faceId);
    }

    @Override
    public DedupFaceCheck findByFaceId(String faceId) {
        String sql = "SELECT * FROM HDB_DEDUP_FACE_CHECK WHERE FACE_ID = ?";
        RowMapper<DedupFaceCheck> rowMapper = new BeanPropertyRowMapper<>(DedupFaceCheck.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, faceId);
    }

    @Override
    public List<DedupFaceCheck> findAll() {
        String sql = "SELECT * FROM HDB_DEDUP_FACE_CHECK";
        RowMapper<DedupFaceCheck> rowMapper = new BeanPropertyRowMapper<>(DedupFaceCheck.class);
        return jdbcTemplate.query(sql, rowMapper);
    }
}

