package com.hr.repository;

import com.hr.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findByEmail(String email);
    List<Person> findByJobTitle(String jobTitle);
    List<Person> findBySex(char s);

}
