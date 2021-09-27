package com.example.springthymeleaf.repository;

import com.example.springthymeleaf.entity.RecordEntity;
import org.springframework.data.repository.CrudRepository;

public interface RecordRepo extends CrudRepository<RecordEntity, Long> {
    RecordEntity findByName(String name);
    RecordEntity findByLink(String link);
}
