package com.example.springthymeleaf.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(userPermissions()),
    ADMIN(adminPermissions());

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    private static Set<Permission> userPermissions(){
        Set<Permission> set = new HashSet<Permission>();
        set.add(Permission.READ);
        set.add(Permission.LEARN);
        return set;
    }

    private static Set<Permission> adminPermissions(){
        Set<Permission> set = new HashSet<Permission>();
        set.add(Permission.READ);
        set.add(Permission.WRITE);
        return set;
    }

    public Set<Permission> getPermissions(){
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthority(){
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
