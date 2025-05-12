package com.guesthousemanagement.guesthousemanagementsystem.service.impl;

import com.guesthousemanagement.guesthousemanagementsystem.dto.user.UserResponse;
import com.guesthousemanagement.guesthousemanagementsystem.entity.user.User;
import com.guesthousemanagement.guesthousemanagementsystem.repository.UserRepository;
import com.guesthousemanagement.guesthousemanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //Method to get all users
    @Override
    public List<UserResponse> getAllUsers() {
         List<User> user = userRepository.findAll();
         List<UserResponse> userResponses =  new ArrayList<>();
         for(User u : user){
             userResponses.add(this.mapUserToUserResponse(u));
         }
         return userResponses;
    }

    //Method to saved user details in a DataBase
    @Override
    public UserResponse addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return this.mapUserToUserResponse(savedUser);
    }



    //Method to get user details by userId
    @Override
    public UserResponse getUserById(long userId) {
        Optional<User> userOptional =userRepository.findById(userId);
        if(userOptional.isPresent()){
            return this.mapUserToUserResponse(userOptional.get());

        }
        else{
            throw new UsernameNotFoundException("User not Found !!!");
        }


    }

    //Method to delete User details
    @Override
    public void deleteUser(User user) {
        if (!userRepository.existsById(user.getUserId())) {
            throw new UsernameNotFoundException("User not found !!! ");
        }
        userRepository.delete(user);
    }

    //Method to update User details
    @Override
    public UserResponse updateUser(User user) {
        Optional<User> vaildUser = userRepository.findById(user.getUserId());
        if(vaildUser.isPresent()){
            User updateUser = vaildUser.get();

            updateUser.setUserName(user.getUserName());
            updateUser.setUserEmail(user.getUserEmail());
            updateUser.setUserMobile(user.getUserMobile());
            updateUser.setGender(user.getGender());
            updateUser.setDateOfBirth(user.getDateOfBirth());
            updateUser.setAddress(user.getAddress());
            updateUser.setUserRole(user.getUserRole());

            if (user.getPassword() != null && !user.getPassword().isBlank()) {
                updateUser.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            User updatedUser = userRepository.save(updateUser);
            return this.mapUserToUserResponse(updatedUser);
        }
        else{
            throw new UsernameNotFoundException("Invalid User!!");
        }
    }


    //Method for converting User Entity to UserResponse DTO
    private UserResponse mapUserToUserResponse(User user){
        UserResponse response = new UserResponse();
        response.setUserId(user.getUserId());
        response.setUserName(user.getUserName());
        response.setUserEmail(user.getUserEmail());
        response.setUserMobile(user.getUserMobile());
        response.setGender(user.getGender());
        response.setDateOfBirth(user.getDateOfBirth());
        response.setAddress(user.getAddress());
        response.setUserRole(user.getUserRole());

        return response;
    }

}
