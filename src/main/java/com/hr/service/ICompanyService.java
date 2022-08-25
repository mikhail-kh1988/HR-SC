package com.hr.service;

import com.hr.dto.CompanyDto;

public interface ICompanyService {

    long createCompany(CompanyDto dto);
    void updateCompany(long companyId, CompanyDto dto);
    int getTaxPayroll(long compId);

}
