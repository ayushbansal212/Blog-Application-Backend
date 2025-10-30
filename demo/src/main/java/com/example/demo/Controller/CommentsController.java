package com.example.demo.Controller;

import com.example.demo.Entity.Comments;
import com.example.demo.service.CommentsService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {
    @Autowired
    CommentsService commentsService;
    @GetMapping("get/blog/{id}")
    public List<Comments> getAllComments(@PathVariable ObjectId id) {
        return commentsService.getAllComments(id);
    }
    @PostMapping("/blog/{id}")
    public Comments addComments(@RequestBody Comments comment, @PathVariable ObjectId id) {
        return commentsService.addComment(comment, id);
    }
    @GetMapping("/get/{id}")
    public Comments getComment(ObjectId id){
        return commentsService.getComment(id);
    }
    @PutMapping("/update/{id}")
    public Comments updateComment(@PathVariable ObjectId id,@RequestBody Comments comment){
        return commentsService.updateComment(id,comment);
    }
    @DeleteMapping("/delete/{id}")
    public Comments deleteComment(@PathVariable ObjectId id){
        return commentsService.deleteComment(id);
    }
}
