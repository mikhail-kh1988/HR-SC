package com.hr.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "org_type")
    private String orgType;

    @Column(name = "tax_percent")
    private int taxPercent;

    @Column(name = "tax_payroll")
    private int taxPayroll;


}
