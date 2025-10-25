package com.example.demo.Repository;

import com.example.demo.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, ObjectId> {

    User findByUsername(String username);
}
