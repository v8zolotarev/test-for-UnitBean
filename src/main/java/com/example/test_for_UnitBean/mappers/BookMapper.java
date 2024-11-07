package com.example.test_for_UnitBean.mappers;

import com.example.test_for_UnitBean.dto.BookDTO;
import com.example.test_for_UnitBean.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDTO bookToBookDTO(Book book);

    Book bookDTOToBook(BookDTO bookDTO);
}
