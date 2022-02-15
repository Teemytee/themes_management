package com.example.springthymeleaf.security;

import com.example.springthymeleaf.model.User;
import com.example.springthymeleaf.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private final UserRepo userRepo;

    @Autowired
    public UserDetailsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));
        return SecurityUser.fromUser(user);
    }

    public User getUserByEmail(String email){
        User user = userRepo.findUserByEmail(email);
        return user;
    }

    public User saveUser(User user){
        return userRepo.save(user);
    }



}
