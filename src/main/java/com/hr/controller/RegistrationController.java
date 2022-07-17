package com.hr.controller;

import com.hr.dto.ApplicantDto;
import com.hr.dto.ResponseDto;
import com.hr.service.IApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private IApplicantService applicantService;

    @PostMapping("/")
    public ResponseEntity<ResponseDto> registrationApplicant(@RequestBody ApplicantDto dto){
        applicantService.registration(dto);
        return ResponseEntity.ok(new ResponseDto("Вы успешно зарегистрировались"));
    }

}
