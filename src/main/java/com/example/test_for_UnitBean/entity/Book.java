package com.example.test_for_UnitBean.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "publishedYear")
    private int publishedYear;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
