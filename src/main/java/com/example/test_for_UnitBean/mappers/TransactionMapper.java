package com.example.test_for_UnitBean.mappers;

import com.example.test_for_UnitBean.dto.TransactionDTO;
import com.example.test_for_UnitBean.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    TransactionDTO transactionToTransactionDTO(Transaction transaction);

    Transaction transactionDTOToTransaction(TransactionDTO transactionDTO);
}
