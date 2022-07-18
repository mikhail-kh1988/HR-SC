package com.hr.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PersonDto {

    private String family;
    private String name;
    private String fatherName;
    private String email;
    private char sex;
    private String jobTitle;
    private LocalDate birthday;
}
