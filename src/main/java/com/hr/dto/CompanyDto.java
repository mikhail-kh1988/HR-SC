package com.hr.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDto {

    private String name;
    private String fullName;
    private String orgType;
    private int percent;
    private int taxPayroll;
}
