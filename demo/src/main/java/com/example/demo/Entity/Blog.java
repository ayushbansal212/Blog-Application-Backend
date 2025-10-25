package com.example.demo.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Document
public class Blog {
    @Id
    ObjectId id;
    String title;
    String content;
    @DBRef
    List<Comments> comments= new ArrayList<>();
    int commentsCount;
}
