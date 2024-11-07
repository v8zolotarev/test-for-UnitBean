package com.example.test_for_UnitBean.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AuthorDTO {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private List<Long> bookIds;
}
