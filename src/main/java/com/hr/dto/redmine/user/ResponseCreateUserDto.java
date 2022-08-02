package com.hr.dto.redmine.user;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ResponseCreateUserDto {

    private User user;

    @Getter
    @Setter
    private class User{
        public int id;
        public String login;
        public boolean admin;
        public String firstname;
        public String lastname;
        public String mail;
        public Date created_on;
        public Date updated_on;
        public Object last_login_on;
        public Date passwd_changed_on;
        public Object twofa_scheme;
        public String api_key;
        public int status;
    }
}
