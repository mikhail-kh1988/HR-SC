package com.hr.aop;

import com.hr.dto.CompanyDto;
import com.hr.entity.CompanyHistory;
import com.hr.repository.CompanyHistoryRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class ChangeHistoryCompany {

    @Autowired
    private CompanyHistoryRepository repository;

    @Pointcut("execution(* com.hr.service.ICompanyService.updateCompany(..))")
    private void callUpdateCompany(){}

    @After("callUpdateCompany()")
    public void afterUpdateCompany(JoinPoint joinPoint){
        CompanyHistory companyHistory = new CompanyHistory();

        Object[] objects = joinPoint.getArgs();
        CompanyDto dto = (CompanyDto) objects[1];

        companyHistory.setCreateDate(LocalDateTime.now());
        companyHistory.setHistory("Название компании изменено на "+dto.getName());

        repository.save(companyHistory);
    }

}
