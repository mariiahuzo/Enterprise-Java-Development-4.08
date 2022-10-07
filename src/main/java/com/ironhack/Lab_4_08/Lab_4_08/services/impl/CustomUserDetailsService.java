package com.ironhack.Lab_4_08.Lab_4_08.services.impl;


import com.ironhack.Lab_4_08.Lab_4_08.models.User;
import com.ironhack.Lab_4_08.Lab_4_08.repositories.UserRepository;
import com.ironhack.Lab_4_08.Lab_4_08.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("User doesn't exist");
        }

        CustomUserDetails customUserDetails = new CustomUserDetails(userOptional.get());

        return customUserDetails;
    }
}
