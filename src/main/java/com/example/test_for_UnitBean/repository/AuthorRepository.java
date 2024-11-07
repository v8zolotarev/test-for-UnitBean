package com.example.test_for_UnitBean.repository;

import com.example.test_for_UnitBean.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a " +
            "JOIN a.books b " +
            "JOIN Transaction t ON t.book.id = b.id " +
            "WHERE t.timestamp BETWEEN :startDate AND :endDate " +
            "GROUP BY a.id " +
            "ORDER BY COUNT(t.id) DESC")
    List<Author> findMostPopularAuthors(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
