package com.example.springthymeleaf.service;


import com.example.springthymeleaf.entity.RecordEntity;
import com.example.springthymeleaf.entity.RecordForMarkEntity;
import com.example.springthymeleaf.repository.RecordForMarkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordForMarkService {
    @Autowired
    private RecordForMarkRepo recordForMarkRepo;

    public RecordForMarkEntity postTheme(RecordForMarkEntity recordForMark){
        return recordForMarkRepo.save(recordForMark);
    }

    public List<RecordForMarkEntity> getAllRecordsForMark(){
        List<RecordForMarkEntity> recordEntityForMarkList = new ArrayList<>();
        recordForMarkRepo.findAll().forEach(recordEntityForMarkList::add);
        return recordEntityForMarkList;
    }
}
