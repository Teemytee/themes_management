package com.example.springthymeleaf.model;

public enum Permission {
    READ("read"),
    WRITE("write"),
    LEARN("learn");
    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
