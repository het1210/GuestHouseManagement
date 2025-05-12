package com.guesthousemanagement.guesthousemanagementsystem.service.impl;

import com.guesthousemanagement.guesthousemanagementsystem.entity.user.User;
import com.guesthousemanagement.guesthousemanagementsystem.entity.user.UserPrincipal;
import com.guesthousemanagement.guesthousemanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUserName(username);
        User user = userRepository.findByUserEmail(username);
        if(user == null){
            System.out.println("User Not Found");
            throw  new UsernameNotFoundException("User Not Found");
        }
        return new UserPrincipal(user);
    }
}
