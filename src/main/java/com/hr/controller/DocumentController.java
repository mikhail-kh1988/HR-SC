package com.hr.controller;

import com.hr.dto.DocumentDto;
import com.hr.dto.ResponseDto;
import com.hr.service.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private IDocumentService service;

    @PutMapping("/")
    public ResponseEntity<ResponseDto> createNewDocument(@RequestBody DocumentDto dto){
        return ResponseEntity.ok(new ResponseDto(service.createDocument(dto)));
    }

    @GetMapping("/{name}/{prefix}/prefix")
    public ResponseEntity<ResponseDto> createNewPrefix(@PathVariable String name, @PathVariable String prefix){
        service.addPrefix(name, prefix);
        return ResponseEntity.ok(new ResponseDto("ok"));
    }

    @GetMapping("/types")
    public ResponseEntity<?> getAllPrefix(){
        return ResponseEntity.ok(service.getDocumentsType());
    }

    @GetMapping("/{exID}/")
    public ResponseEntity<?> getDocumentByExternalId(@PathVariable String exID){
        return ResponseEntity.ok(service.getDocumentByExternalId(exID));
    }

}
