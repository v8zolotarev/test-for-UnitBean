package com.example.test_for_UnitBean.dto;

import com.example.test_for_UnitBean.enums.TransactionType;
import lombok.Data;
import java.util.Date;

@Data
public class TransactionDTO {
    private TransactionType transactionType;
    private Date timestamp;
    private Long readerId;
    private Long bookId;
}
