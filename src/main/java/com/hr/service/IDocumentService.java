package com.hr.service;

import com.hr.dto.DocumentDto;
import com.hr.entity.Document;
import com.hr.entity.DocumentType;

import java.time.LocalDateTime;
import java.util.List;

public interface IDocumentService {

    Document getDocumentById(Long id);
    Document getDocumentByExternalId(String exID);
    List<Document> getDocumentsBetweenCreateDate(LocalDateTime startDate, LocalDateTime endDate);
    void addPrefix(String name, String prefix);
    List<DocumentType> getDocumentsType();
    List<Document> getDocumentByPrefix(String prefix);
    List<Document> getDocumentsByPersonId(Long id);
    String createDocument(DocumentDto dto);
}
