package com.example.test_for_UnitBean.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ReaderDTO {
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String gender;
    private Date birthDate;
}
