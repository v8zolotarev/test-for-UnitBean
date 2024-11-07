package com.example.test_for_UnitBean.repository;

import com.example.test_for_UnitBean.entity.Transaction;
import com.example.test_for_UnitBean.enums.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByTimestampBetweenAndTransactionType(Date startDate, Date endDate, TransactionType transactionType);
    List<Transaction> findByTransactionType(TransactionType transactionType);
}
