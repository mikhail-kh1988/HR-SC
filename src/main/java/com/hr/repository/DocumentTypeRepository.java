package com.hr.repository;

import com.hr.entity.DocumentType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeRepository extends CrudRepository<DocumentType, Long> {
    DocumentType findByPrefix(String prefix);
}
