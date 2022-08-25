package com.hr.service.impl;

import com.hr.dto.CompanyDto;
import com.hr.entity.Company;
import com.hr.repository.CompanyRepository;
import com.hr.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private CompanyRepository repository;

    @Override
    public long createCompany(CompanyDto dto) {
        Company company = new Company();

        company.setName(dto.getName());
        company.setFullName(dto.getFullName());
        company.setOrgType(dto.getOrgType());
        company.setTaxPercent(dto.getPercent());
        company.setTaxPayroll(dto.getTaxPayroll());

        Company save = repository.save(company);
        return save.getId();
    }

    @Override
    public void updateCompany(long companyId, CompanyDto dto) {
        Company company = repository.findById(companyId).get();

        company.setTaxPayroll(dto.getTaxPayroll());
        company.setName(dto.getName());
        company.setFullName(dto.getFullName());
        company.setOrgType(dto.getOrgType());
        company.setTaxPercent(dto.getPercent());

        repository.save(company);
    }

    @Override
    public int getTaxPayroll(long compId) {

        Company company = repository.findById(compId).get();

        return company.getTaxPayroll();
    }
}
