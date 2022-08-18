package com.hr.repository;

import com.hr.entity.PersonHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PersonHistoryRepository extends CrudRepository<PersonHistory, Long> {

    List<PersonHistory> findByCreateBy(String login);
    List<PersonHistory> findByCreateDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    List<PersonHistory> findByPersonID(long ID);
}
