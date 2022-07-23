package com.hr.service.impl;

import com.hr.entity.Person;
import com.hr.entity.User;
import com.hr.repository.UserRepository;
import com.hr.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repository;

    @Override
    public void createUserFromPerson(Person person) {
        User user = new User();
        user.setCreateDate(LocalDateTime.now());
        user.setStatus(1000);

        String[] email = person.getEmail().split("@");

        user.setLogin(email[0]+"_"+person.getID());
        repository.save(user);
    }

    @Override
    public void createUser(String login, String password) {
        User user = new User();
        user.setStatus(1000);
        user.setLogin(login);
        user.setPassword(password);
        user.setCreateDate(LocalDateTime.now());

        repository.save(user);
    }

    @Override
    public boolean changeStatusUser(int status, long userID) {
        User user = repository.findById(userID).get();

        if (user != null){

            user.setStatus(status);

            repository.save(user);

            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        for (User u:repository.findAll()) {
            users.add(u);
        }

        return users;
    }

    @Override
    public User findUserByLogin(String login) {
        return repository.findByLogin(login);
    }

    @Override
    public List<User> getUserByStatus(int status) {
        return null;
    }

}
