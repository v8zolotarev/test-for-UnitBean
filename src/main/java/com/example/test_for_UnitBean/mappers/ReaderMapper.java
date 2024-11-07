package com.example.test_for_UnitBean.mappers;

import com.example.test_for_UnitBean.dto.ReaderDTO;
import com.example.test_for_UnitBean.entity.Reader;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReaderMapper {

    ReaderDTO toDTO(Reader reader);

    Reader toEntity(ReaderDTO readerDTO);
}
