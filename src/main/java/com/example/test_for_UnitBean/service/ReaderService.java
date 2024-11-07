package com.example.test_for_UnitBean.service;

import com.example.test_for_UnitBean.dto.ReaderDTO;
import com.example.test_for_UnitBean.entity.Reader;
import com.example.test_for_UnitBean.entity.Transaction;
import com.example.test_for_UnitBean.enums.TransactionType;
import com.example.test_for_UnitBean.mappers.ReaderMapper;
import com.example.test_for_UnitBean.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final TransactionRepository transactionRepository;
    private final ReaderMapper readerMapper;

    public Optional<ReaderDTO> getMostReadingReader() {
        List<Transaction> transactions = transactionRepository.findByTransactionType(TransactionType.BORROW);

        Map<Reader, Long> readerCountMap = new HashMap<>();

        for (Transaction transaction : transactions) {
            Reader reader = transaction.getReader();
            readerCountMap.put(reader, readerCountMap.getOrDefault(reader, 0L) + 1);
        }

        return readerCountMap.entrySet().stream()
                .max(comparingByValue())
                .map(Map.Entry::getKey)
                .map(readerMapper::toDTO);
    }

    public List<ReaderDTO> getReadersSortedByUnreturnedBooks() {
        List<Transaction> transactions = transactionRepository.findAll();

        Map<Reader, Long> unreturnedBooksCount = transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getReader,
                        Collectors.summingLong(tx -> tx.getTransactionType() == TransactionType.BORROW ? 1 : -1)
                ));

        return unreturnedBooksCount.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .sorted(Map.Entry.<Reader, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .map(readerMapper::toDTO)
                .collect(Collectors.toList());
    }
}
