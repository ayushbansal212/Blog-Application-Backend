package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/user")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("save")
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }
    @DeleteMapping("delete")
    public void deleteUser(){
        userService.deleteUser();
    }
    @PutMapping("change/password")
    public void changePassword(@RequestBody String oldPassword, String newPassword){
        userService.changePassword(newPassword,oldPassword);
    }


}
