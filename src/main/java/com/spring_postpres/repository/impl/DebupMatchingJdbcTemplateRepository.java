package com.spring_postpres.repository.impl;

import com.spring_postpres.entity.DebupMatching;
import com.spring_postpres.entity.Matching;
import com.spring_postpres.repository.DebupMatchingRepository;
import com.spring_postpres.repository.MatchingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DebupMatchingJdbcTemplateRepository implements DebupMatchingRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DebupMatchingJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(DebupMatching matching) {
        String sql = "INSERT INTO HDB_DEDUP_MATCHING (FACE_ID, MATCHING_FACE_ID) VALUES (?, ?)";
        return jdbcTemplate.update(sql, matching.getFaceId(), matching.getMatchingFaceId());
    }

    @Override
    public List<DebupMatching> findByFaceId(String faceId) {
        String sql = "SELECT * FROM HDB_DEDUP_MATCHING WHERE FACE_ID = ?";
        RowMapper<DebupMatching> rowMapper = new BeanPropertyRowMapper<>(DebupMatching.class);
        return jdbcTemplate.query(sql, rowMapper, faceId);
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM HDB_DEDUP_MATCHING WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }
}

