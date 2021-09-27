package com.example.springthymeleaf.security;

import com.example.springthymeleaf.model.Status;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class SecurityUser implements UserDetails {
    private final String username;
    private final String password;
    private final List<SimpleGrantedAuthority> authorityList;
    private final boolean isActive;

    public SecurityUser(String username, String password, List<SimpleGrantedAuthority> authorityList, boolean isActive) {
        this.username = username;
        this.password = password;
        this.authorityList = authorityList;
        this.isActive = isActive;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    public static UserDetails fromUser(com.example.springthymeleaf.model.User user){
        return new User(
                user.getEmail(), user.getPassword(), user.getStatus().equals(Status.ACTIVE),
                user.getStatus().equals(Status.ACTIVE), user.getStatus().equals(Status.ACTIVE),
                user.getStatus().equals(Status.ACTIVE), user.getRole().getAuthority()
        );
    }
}
