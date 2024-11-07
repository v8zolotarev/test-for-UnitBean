package com.example.test_for_UnitBean.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookDTO {
    private String title;
    private int publishedYear;
    private List<Long> authorIds;
}