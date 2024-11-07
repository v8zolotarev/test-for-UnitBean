package com.example.test_for_UnitBean.controller;

import com.example.test_for_UnitBean.dto.AuthorDTO;
import com.example.test_for_UnitBean.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/most-popular")
    public ResponseEntity<AuthorDTO> getMostPopularAuthor(
            @RequestParam("startDate")
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam("endDate")
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

        return authorService.getMostPopularAuthor(startDate, endDate)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}