package com.example.springthymeleaf.controller;


import com.example.springthymeleaf.entity.RecordEntity;
import com.example.springthymeleaf.exception.RecordNotFoundException;
import com.example.springthymeleaf.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/themes")

public class RecordController {

    @Autowired
    private RecordService recordService;

    @PostMapping("/post")
    public ResponseEntity postTheme(@RequestBody RecordEntity record){
        try{
            recordService.postTheme(record);
            return ResponseEntity.ok().body("Тема успешно добавлена");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/get")
    public List<RecordEntity> getThemes(){
        return recordService.getAllRecords();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTheme(@PathVariable Long id){
        try{
            return ResponseEntity.ok(recordService.deleteTheme(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/all")
    String getMainPage(Model model){
        List<RecordEntity> recordEntityList = getThemes();
        model.addAttribute("text", "Here's themes you should read");
        model.addAttribute("recordsTable", recordEntityList);
        return "records";
    }

    @GetMapping("/get/oneThemeId")
    public ResponseEntity getOneThemeById(@RequestParam Long id){
        try{
            return ResponseEntity.ok(recordService.getOneThemeById(id));
        } catch (RecordNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/get/oneThemeName")
    public ResponseEntity getOneThemeByName(@RequestParam String name){
        try{
            return ResponseEntity.ok(recordService.getOneThemeByName(name));
        } catch (RecordNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/get/oneThemeLink")
    public ResponseEntity getOneThemeByLink(@RequestParam String link){
        try{
            return ResponseEntity.ok(recordService.getOneThemeByLink(link));
        } catch (RecordNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTheme(@RequestBody RecordEntity record, @PathVariable Long id){
        try{
            return ResponseEntity.ok(recordService.updateTheme(record, id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }


}
