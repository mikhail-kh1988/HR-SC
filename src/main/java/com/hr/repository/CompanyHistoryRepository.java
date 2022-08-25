package com.hr.repository;

import com.hr.entity.CompanyHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyHistoryRepository extends CrudRepository<CompanyHistory, Long> {

}
