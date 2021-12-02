package com.cnpm.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cnpm.entity.CustomUserDetails;
import com.cnpm.entity.UserEntity;
import com.cnpm.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
       
        UserEntity userEntity = userRepository.findByUserName(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(userEntity);
    }
    

}