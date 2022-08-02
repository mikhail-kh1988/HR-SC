package com.hr.dto.redmine.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Status {
    private int id;
    private String name;
    private boolean is_closed;
}
