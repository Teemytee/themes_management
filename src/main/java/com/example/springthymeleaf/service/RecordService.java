package com.example.springthymeleaf.service;


import com.example.springthymeleaf.entity.RecordEntity;
import com.example.springthymeleaf.exception.RecordNotFoundException;
import com.example.springthymeleaf.model.Record;
import com.example.springthymeleaf.repository.RecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordRepo recordRepo;

    public RecordEntity postTheme(RecordEntity record){
        return recordRepo.save(record);
    }

    public RecordEntity getOneThemeById(Long id) throws RecordNotFoundException {
        RecordEntity record = recordRepo.findById(id).get();
        if(record == null){
            throw new RecordNotFoundException("Тема с таким id не найдена");
        }
        return record;
    }

    public Long deleteTheme(Long id) {
        recordRepo.deleteById(id);
        return id;
    }

    public List<RecordEntity> getAllRecords(){
        List<RecordEntity> recordEntityList = new ArrayList<>();
        recordRepo.findAll().forEach(recordEntityList::add);
        return recordEntityList;
    }

    public Record getOneThemeByName(String name) throws RecordNotFoundException {
        RecordEntity record = recordRepo.findByName(name);
        if(record == null){
            throw new RecordNotFoundException("Тема с таким названием не найдена");
        }
        return Record.toModel(record);
    }

    public Record getOneThemeByLink(String link) throws RecordNotFoundException {
        RecordEntity record = recordRepo.findByLink(link);
        if(record == null){
            throw new RecordNotFoundException("Тема с такой ссылкой не найдена");
        }
        return Record.toModel(record);
    }
}
