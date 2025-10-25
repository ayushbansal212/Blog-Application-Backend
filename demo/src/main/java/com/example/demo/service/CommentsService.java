package com.example.demo.service;

import com.example.demo.Entity.Blog;
import com.example.demo.Entity.Comments;
import com.example.demo.Repository.BlogRepo;
import com.example.demo.Repository.CommentsRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsService {
    @Autowired
    BlogRepo blogRepo;
    @Autowired
    CommentsRepo commentsRepo;
    public List<Comments> getAllComments(ObjectId id){
        Optional<Blog> optionalBlog=blogRepo.findById(id);
        if(optionalBlog.isPresent()){
            return optionalBlog.get().getComments();
        }
        return null;
    }
    public Comments addComment(Comments comment,ObjectId id){
        Optional<Blog> optionalBlog=blogRepo.findById(id);
        if(optionalBlog.isPresent()){
            Blog blog=optionalBlog.get();
            commentsRepo.save(comment);
            blog.getComments().add(comment);
            blogRepo.save(blog);
        }
        return comment;
    }

    public Comments getComment(ObjectId id) {
        Optional<Comments> optionalComments= commentsRepo.findById(id);
        if(optionalComments.isPresent()){
            Comments comments= optionalComments.get();
            return comments;
        }
        return null;
    }
}
