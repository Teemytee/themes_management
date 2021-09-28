package com.example.springthymeleaf.controller;


import com.example.springthymeleaf.entity.RecordEntity;
import com.example.springthymeleaf.exception.RecordNotFoundException;
import com.example.springthymeleaf.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/themes")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @GetMapping("/get")
    public List<RecordEntity> getThemes(){
        return recordService.getAllRecords();
    }

    // Delete UI
    // GET - потому что редирект на стартовую страницу
    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('write')")
    public String deleteTheme(@PathVariable Long id){
        recordService.deleteTheme(id);
        return "redirect:/themes/mainPage";
    }

    // Read UI main
    @GetMapping("/mainPage")
    @PreAuthorize("hasAuthority('read')")
    String getMainPageAdmin(Model model){
        List<RecordEntity> recordEntityList = getThemes();
        model.addAttribute("text", "Here's themes you should read");
        model.addAttribute("recordsTable", recordEntityList);
        model.addAttribute("record", new RecordEntity());
        return "records";
    }

    // Create UI
    @GetMapping("/create")
    @PreAuthorize("hasAuthority('write')")
    public String createRecordForm(Model model){
        model.addAttribute("record", new RecordEntity());
        return "putRecord";
    }
    @PostMapping("/create")
    @PreAuthorize("hasAuthority('write')")
    public String createRecord(RecordEntity record){
        recordService.postTheme(record);
        return "redirect:/themes/mainPage";

    }

    // Update UI
    @GetMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('write')")
    public String updateRecordForm(Model model, @PathVariable("id") Long recordId) throws RecordNotFoundException {
        model.addAttribute("record", recordService.getOneThemeById(recordId));
        return "recordEdit";
    }

    @PostMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('write')")
    public String updateRecord(RecordEntity record) {
        recordService.postTheme(record);
        return "redirect:/themes/mainPage";
    }

    // UI (future) Filtration
    @PostMapping("/post/getThemeByLink")
    public ResponseEntity getOneThemeByLinkPost(@RequestBody RecordEntity record){
        try{
            return ResponseEntity.ok(recordService.getOneThemeByLink(record.getLink()));
        } catch (RecordNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping("/post/getThemeByName")
    public ResponseEntity getOneThemeByNamePost(@RequestBody RecordEntity record){
        try{
            return ResponseEntity.ok(recordService.getOneThemeByName(record.getName()));
        } catch (RecordNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping("/post/getThemeById")
    public ResponseEntity getOneThemeByIdPost(@RequestBody RecordEntity record){
        try{
            return ResponseEntity.ok(recordService.getOneThemeById(record.getId()));
        } catch (RecordNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
