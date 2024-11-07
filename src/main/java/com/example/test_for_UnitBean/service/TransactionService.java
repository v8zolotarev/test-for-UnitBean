package com.example.test_for_UnitBean.service;

import com.example.test_for_UnitBean.entity.Book;
import com.example.test_for_UnitBean.entity.Reader;
import com.example.test_for_UnitBean.entity.Transaction;
import com.example.test_for_UnitBean.repository.BookRepository;
import com.example.test_for_UnitBean.repository.ReaderRepository;
import com.example.test_for_UnitBean.repository.TransactionRepository;
import com.example.test_for_UnitBean.enums.TransactionType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final ReaderRepository readerRepository;
    private final BookRepository bookRepository;

    public String borrowBook(Long readerId, Long bookId) {
        Reader reader = readerRepository.findById(readerId).orElse(null);
        Book book = bookRepository.findById(bookId).orElse(null);

        if (reader == null || book == null) {
            return "Reader or Book not found";
        }

        Transaction transaction = new Transaction();
        transaction.setReader(reader);
        transaction.setBook(book);
        transaction.setTransactionType(TransactionType.BORROW);
        transaction.setTimestamp(new Date());

        transactionRepository.save(transaction);
        return "Book borrowed successfully";
    }

    public String returnBook(Long readerId, Long bookId) {
        Reader reader = readerRepository.findById(readerId).orElse(null);
        Book book = bookRepository.findById(bookId).orElse(null);

        if (reader == null || book == null) {
            return "Reader or Book not found";
        }

        Transaction transaction = new Transaction();
        transaction.setReader(reader);
        transaction.setBook(book);
        transaction.setTransactionType(TransactionType.RETURN);
        transaction.setTimestamp(new Date());

        transactionRepository.save(transaction);
        return "Book returned successfully";
    }
}
