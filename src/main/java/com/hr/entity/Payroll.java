package com.hr.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "payroll")
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String jobTitle;
    private Integer grade;
    private LocalDate startPeriod;
    private LocalDate endPeriod;
    private String documentName;
    private String documentExternalId;
    private LocalDateTime createDate;
    private BigDecimal totalSum;
    private BigDecimal tax;
    private BigDecimal actualSum;
    private boolean sendToBank;
    private boolean payed;

}
