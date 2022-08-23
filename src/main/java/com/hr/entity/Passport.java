package com.hr.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "passport")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer serial;
    private Integer number;
    private String fio;
    private String whoGet;
    private LocalDate dateOfGet;
    private char sex;
    private LocalDate birthDay;
    private String placeBirth;


}
