package com.hr.repository;

import com.hr.entity.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DocumentsRepository extends CrudRepository<Document, Long> {

    List<Document> findByPrefix(String prefix);
    List<Document> findByCreateDateBetween(LocalDateTime start, LocalDateTime end);
    List<Document> findByPersonID(Long ID);
    Document findByExternalId(String id);

}
