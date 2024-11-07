package com.example.test_for_UnitBean.controller;

import com.example.test_for_UnitBean.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/borrow")
    public ResponseEntity<String> borrowBook(@RequestParam Long readerId, @RequestParam Long bookId) {
        String response = transactionService.borrowBook(readerId, bookId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/return")
    public ResponseEntity<String> returnBook(@RequestParam Long readerId, @RequestParam Long bookId) {
        String response = transactionService.returnBook(readerId, bookId);
        return ResponseEntity.ok(response);
    }
}
