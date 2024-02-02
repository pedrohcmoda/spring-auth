package com.bytep.springauth.service;

import com.bytep.springauth.entity.User;
import com.bytep.springauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(){
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public User registerUser (User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setCreationDate( new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        return userRepository.save(user);
    }
    public User findUserByID(UUID id){
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(User user){
        User foundUser = userRepository.findById(user.getId()).orElse(null);
        if(foundUser != null){
            if(!user.getName().isEmpty()){
                foundUser.setName(user.getName());
            }
            if(!user.getEmail().isEmpty()){
                foundUser.setEmail(user.getEmail());
            }
            if(user.getPassword()!=null && !user.getPassword().isEmpty()){
                foundUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            }
            foundUser.setUpdateDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
            return userRepository.save(foundUser);
        }
        return null;
    }

    public List<User> findUser(){
        return userRepository.findAll();
    }

    public void deleteUserByID(User user){
        userRepository.deleteById(user.getId());
    }
}
