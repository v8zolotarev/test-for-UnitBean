package com.example.test_for_UnitBean.service;

import com.example.test_for_UnitBean.dto.AuthorDTO;
import com.example.test_for_UnitBean.entity.Author;
import com.example.test_for_UnitBean.mappers.AuthorMapper;
import com.example.test_for_UnitBean.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public Optional<AuthorDTO> getMostPopularAuthor(Date startDate, Date endDate) {
        List<Author> authors = authorRepository.findMostPopularAuthors(startDate, endDate);
        if (authors.isEmpty()) {
            return Optional.empty();
        }

        AuthorDTO authorDTO = authorMapper.authorToAuthorDTO(authors.get(0));
        return Optional.of(authorDTO);
    }
}
