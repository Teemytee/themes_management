package com.example.springthymeleaf.model;

import com.example.springthymeleaf.entity.RecordEntity;

public class Record {
    private String theme;
    private String name;
    private String link;
    private Long id;

    public static Record toModel(RecordEntity entity){
        Record model = new Record();
        model.setId(entity.getId());
        model.setLink(entity.getLink());
        model.setName(entity.getName());
        model.setTheme(entity.getTheme());
        return model;
    }

    public Record() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
