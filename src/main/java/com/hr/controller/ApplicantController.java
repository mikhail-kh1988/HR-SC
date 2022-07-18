package com.hr.controller;

import com.hr.dto.ApplicantDto;
import com.hr.dto.ResponseDto;
import com.hr.entity.Applicant;
import com.hr.service.IApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/applicant")
public class ApplicantController {

    @Autowired
    private IApplicantService applicantService;

    @GetMapping("/viewed/{id}")
    public ResponseEntity<?> isViewedApplicant(@PathVariable long id){
        applicantService.applicantIsViewed(id);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/apply/{id}")
    public ResponseEntity<?> applyApplicant(@PathVariable long id){
        applicantService.applyApplicant(id);
        return ResponseEntity.ok(new ResponseDto("Претендент принят в компанию!"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Applicant> getApplicantByID(@PathVariable long id){
        return ResponseEntity.ok(applicantService.getApplicantById(id));
    }

    @GetMapping("/vacancy/{vacId}")
    public ResponseEntity<List<Applicant>> getApplicantsByVacancyId(@PathVariable long vacId){
        return ResponseEntity.ok(applicantService.getApplicantByVacancyId(vacId));
    }

    @GetMapping("/noviewe")
    public ResponseEntity<List<Applicant>> getNotViewedApplicant(){
        return ResponseEntity.ok(applicantService.getNotViewedApplicant());
    }

    @PutMapping("/register")
    public ResponseEntity<?> registrationApplicant(@RequestBody ApplicantDto dto){
        applicantService.registration(dto);
        return ResponseEntity.ok(new ResponseDto("ok"));
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<ResponseDto> getStatusApplicant(@PathVariable long id){
        return ResponseEntity.ok(applicantService.getStatusApplicant(id));
    }

}
