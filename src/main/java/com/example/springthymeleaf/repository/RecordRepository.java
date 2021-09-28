package com.example.springthymeleaf.repository;


import com.example.springthymeleaf.entity.RecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecordRepository extends JpaRepository<RecordEntity, Long> {
    @Query(value = "select * from record r where r.theme like %:keyword% or r.name like %:keyword% or r.link like %:keyword%", nativeQuery = true)
    List<RecordEntity> findByKeyWord(@Param("keyword") String keyword);
}
