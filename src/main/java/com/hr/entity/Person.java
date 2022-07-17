package com.hr.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "family_name", length = 64)
    private String familyName;

    @Column(name = "first_name", length = 64)
    private String firstName;

    @Column(name = "last_name", length = 64)
    private String lastName;
    private String email;
    private char sex;
    private LocalDate birthday;

    @Column(name = "job_title", length = 128)
    private String jobTitle;

    private String description;
    private int grade;

    @Column(name = "create_date")
    private LocalDateTime createDate;
    private int status;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PersonDocument document;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private OrganisationTier organisationTier;

}
