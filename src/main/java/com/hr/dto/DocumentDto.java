package com.hr.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentDto {

    private String name;
    private Long docTypeId;
    private String body;
    private String version;
}
