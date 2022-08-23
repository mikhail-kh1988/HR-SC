package com.hr.controller;

import com.hr.dto.AllDocumentDto;
import com.hr.dto.PersonDto;
import com.hr.dto.ResponseDto;
import com.hr.entity.Person;
import com.hr.entity.PersonDocument;
import com.hr.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @GetMapping("/")
    public ResponseEntity<?> getAllPersons(){
        return ResponseEntity.ok(personService.getAllPersons());
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updatePersons(@RequestBody PersonDto dto, @PathVariable long id){
        return ResponseEntity.ok(personService.updatePerson(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonByID(@PathVariable long id){
        return ResponseEntity.ok(personService.getPersonById(id));
    }

    @PutMapping("/create")
    public ResponseEntity<?> createNewPerson(@RequestBody PersonDto dto){
        return ResponseEntity.ok(personService.createPersonByPersonDto(dto));
    }

    @GetMapping("/{personId}/vacancy/{vacancyId}")
    public ResponseEntity<?> changeGrade(@PathVariable long personId, @PathVariable long vacancyId){
        personService.setPersonGradeByVacancy(vacancyId, personId);
        return ResponseEntity.ok(new ResponseDto("Для персоны изменен грейд."));
    }

    @GetMapping("/job/{job}")
    public ResponseEntity<List<Person>> getPersonsByJobTitle(@PathVariable String job){
        return ResponseEntity.ok(personService.getPersonByJobTitle(job));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Person> getPersonsByEmail(@PathVariable String email){
        return ResponseEntity.ok(personService.getPersonByEmail(email));
    }

    @PostMapping("/{id}/document/add")
    public ResponseEntity<ResponseDto> addDocuments(@PathVariable long id, @RequestBody AllDocumentDto dto){
        personService.addDocumentForPerson(id, dto);
        return ResponseEntity.ok(new ResponseDto("ok"));
    }

    @GetMapping("/{personId}/document")
    public ResponseEntity<PersonDocument> getPersonDocuments(@PathVariable long personId){
        return ResponseEntity.ok(personService.getPersonById(personId).getDocument());
    }

    /*@GetMapping("/create/{id}/login")
    public ResponseEntity<ResponseDto> createLoginForPersonId(@PathVariable long id){
        personService.createLoginForPerson(id);
        return ResponseEntity.ok(new ResponseDto("Логин для пользователя создан"));
    }*/

}
