package com.example.test_for_UnitBean.mappers;

import com.example.test_for_UnitBean.dto.AuthorDTO;
import com.example.test_for_UnitBean.entity.Author;
import com.example.test_for_UnitBean.entity.Book;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDTO authorToAuthorDTO(Author author);

    Author authorDTOToAuthor(AuthorDTO authorDTO);

    default List<Long> mapBooksToBookIds(List<Book> books) {
        return books.stream().map(Book::getId).collect(Collectors.toList());
    }
}
