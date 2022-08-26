package com.hr.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "persons_documents")
public class PersonDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Passport passport;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private SNILS snils;

    private int insurance_id;
    private int currentGrade;
    private long redmineId;
    private BigDecimal salary;

}
