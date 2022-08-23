package com.hr.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Getter
@Setter
public class AllDocumentDto {

    private String fio;
    private String sex;
    private LocalDate birthDay;
}
