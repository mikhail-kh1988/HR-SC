package com.hr.service;

import com.hr.entity.Person;
import com.hr.entity.User;

import java.util.List;

public interface IUserService {

    void createUserFromPerson(Person person);
    void createUser(String login, String password);
    boolean changeStatusUser(int status, long userID);
    List<User> getAllUsers();
    User findUserByLogin(String login);
    List<User> getUserByStatus(int status);

}
