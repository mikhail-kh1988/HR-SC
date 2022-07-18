package com.hr.repository;

import com.hr.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByLogin(String login);
    List<User> findByStatus(int status);

}
