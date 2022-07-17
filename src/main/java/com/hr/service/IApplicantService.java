package com.hr.service;

import com.hr.dto.ApplicantDto;
import com.hr.dto.ResponseDto;

public interface IApplicantService {

    ResponseDto registration(ApplicantDto dto);

}
