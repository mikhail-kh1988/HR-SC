package com.hr.dto.redmine.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private String mail;
    private int auth_source_id;
    private String mail_notification; //only_my_events
    private boolean must_change_passwd;
    private boolean generate_password;
}
