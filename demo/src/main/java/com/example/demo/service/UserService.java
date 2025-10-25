package com.example.demo.service;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public User saveUser(User user){
        BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder(12);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
    public void deleteUser(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user =userRepo.findByUsername(username);
        userRepo.deleteById(user.getId());
    }
    public void changePassword(String newPassword, String oldPassword){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user =userRepo.findByUsername(username);
        BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
        String password= bCryptPasswordEncoder.encode(newPassword);
        if(!password.equals(oldPassword)){
            return;
        }
        String newEncodePassword= bCryptPasswordEncoder.encode(newPassword);
        user.setPassword( newEncodePassword);
    }


}
