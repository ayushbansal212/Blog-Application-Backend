package com.example.demo.Repository;

import com.example.demo.Entity.Blog;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepo extends MongoRepository<Blog,ObjectId> {

    Blog findById(Long id);
}
