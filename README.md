#document for crud for postgres
## 1. database
```sql
CREATE TABLE HDB_DEDUP_FACE_CHECK (
    FACE_ID VARCHAR(50) PRIMARY KEY,
    IS_CHECKED BOOLEAN
);

CREATE TABLE HDB_DEDUP_MATCHING (
    ID SERIAL PRIMARY KEY,
    FACE_ID VARCHAR(50) REFERENCES HDB_DEDUP_FACE_CHECK(FACE_ID),
    MATCHING_FACE_ID VARCHAR(50),
    CONSTRAINT face_matching UNIQUE (FACE_ID, MATCHING_FACE_ID)
);
```
Insert data for testing
```sql
INSERT INTO HDB_DEDUP_FACE_CHECK (FACE_ID, IS_CHECKED) VALUES
    ('face_001', true),
    ('face_002', false),
    ('face_003', true);

INSERT INTO HDB_DEDUP_MATCHING (FACE_ID, MATCHING_FACE_ID) VALUES
    ('face_001', 'matching_face_001'),
    ('face_001', 'matching_face_002'),
    ('face_002', 'matching_face_003'),
    ('face_003', 'matching_face_004');

```

