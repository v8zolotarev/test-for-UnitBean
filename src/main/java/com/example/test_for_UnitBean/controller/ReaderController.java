package com.example.test_for_UnitBean.controller;

import com.example.test_for_UnitBean.dto.ReaderDTO;
import com.example.test_for_UnitBean.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/readers")
@RequiredArgsConstructor
public class ReaderController {

    private final ReaderService readerService;

    @GetMapping("/most-reading")
    public ResponseEntity<ReaderDTO> getMostReadingReader() {
        return readerService.getMostReadingReader()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/sorted-by-unreturned-books")
    public ResponseEntity<List<ReaderDTO>> getReadersSortedByUnreturnedBooks() {
        List<ReaderDTO> readers = readerService.getReadersSortedByUnreturnedBooks();
        return ResponseEntity.ok(readers);
    }
}
