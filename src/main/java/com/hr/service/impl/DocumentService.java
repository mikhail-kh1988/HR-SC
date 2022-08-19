package com.hr.service.impl;

import com.hr.dto.DocumentDto;
import com.hr.entity.Document;
import com.hr.entity.DocumentType;
import com.hr.repository.DocumentTypeRepository;
import com.hr.repository.DocumentsRepository;
import com.hr.service.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentService implements IDocumentService {

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @Autowired
    private DocumentsRepository documentsRepository;

    @Autowired
    private PersonService personService;

    @Override
    public Document getDocumentById(Long id) {
        return documentsRepository.findById(id).get();
    }

    @Override
    public Document getDocumentByExternalId(String exID) {
        return documentsRepository.findByExternalId(exID);
    }

    @Override
    public List<Document> getDocumentsBetweenCreateDate(LocalDateTime startDate, LocalDateTime endDate) {
        return documentsRepository.findByCreateDateBetween(startDate, endDate);
    }

    @Override
    public void addPrefix(String name, String prefix) {
        DocumentType type = new DocumentType();
        type.setName(name);
        type.setPrefix(prefix);
        type.setCreateDate(LocalDateTime.now());
        documentTypeRepository.save(type);
    }

    @Override
    public List<DocumentType> getDocumentsType() {
        List<DocumentType> types = new ArrayList<>();
        for (DocumentType dt:documentTypeRepository.findAll()) {
            types.add(dt);
        }
        return types;
    }

    @Override
    public List<Document> getDocumentByPrefix(String prefix) {
        return documentsRepository.findByPrefix(prefix);
    }

    @Override
    public List<Document> getDocumentsByPersonId(Long id) {
        return documentsRepository.findByPersonID(id);
    }

    @Override
    public String createDocument(DocumentDto dto) {
        DocumentType type = documentTypeRepository.findById(dto.getDocTypeId()).get();

        Document document = new Document();
        document.setName(dto.getName());
        document.setPrefix(type.getPrefix());
        document.setDocumentType(type);
        document.setDocumentBody(dto.getBody());
        document.setCreateDate(LocalDateTime.now());
        document.setVersion(dto.getVersion());

        Document save = documentsRepository.save(document);
        save.setExternalId(type.getPrefix()+"-"+document.getVersion()+"-"+document.getId());

        documentsRepository.save(save);
        return save.getExternalId();
    }
}
