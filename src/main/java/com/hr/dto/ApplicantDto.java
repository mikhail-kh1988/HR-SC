package com.hr.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;

@Getter
@Setter
public class ApplicantDto {

    private int vacancyId;
    private String fullName;
    private String email;
    private String description;
    private String cvFileName;

}
