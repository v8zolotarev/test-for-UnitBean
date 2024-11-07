package com.example.test_for_UnitBean.repository;

import com.example.test_for_UnitBean.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {

}
