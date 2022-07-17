package com.hr.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "organisation_tier")
public class OrganisationTier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

}
