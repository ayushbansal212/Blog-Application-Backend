package com.example.demo.Entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;
@Document
@Data
public class User {
    @Id
    ObjectId id;
    @Indexed(unique = true)
    String username;
    String password;
    @DBRef
    List<Blog> blogsList =  new ArrayList<>();
    int blogsCount;

}
