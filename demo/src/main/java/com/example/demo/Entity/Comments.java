package com.example.demo.Entity;

import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Document
@Data
public class Comments {
    @Id
    @ToString.Exclude
    ObjectId id;
    String name;
    String contents;
}
