package com.hr.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "applicants")
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "full_name", length = 128)
    private String fullName;
    private String email;
    private String description;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "cv_file_name", length = 64)
    private String cvFileName;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Files files;
    private Boolean applied;
    private Boolean viewed;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Vacancy vacancy;
}
