package com.example.demo.Repository;

import com.example.demo.Entity.Comments;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;

    public interface CommentsRepo extends MongoRepository<Comments, ObjectId> {
}
