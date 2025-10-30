package com.example.demo.service;

import com.example.demo.Entity.Blog;
import com.example.demo.Entity.Comments;
import com.example.demo.Entity.User;
import com.example.demo.Repository.BlogRepo;
import com.example.demo.Repository.CommentsRepo;
import com.example.demo.Repository.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class BlogService {
    @Autowired
    BlogRepo blogRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    CommentsRepo commentsRepo;
    public Blog saveBlog(Blog blog){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user =userRepo.findByUsername(username);
        blogRepo.save(blog);
        user.getBlogsList().add(blog);
        user.setBlogsCount(user.getBlogsCount()+1);
        userRepo.save(user);
        return null ;
    }
    public List<Blog> getAllBlogs(){
        return blogRepo.findAll();
    }
    public List<Blog> getAllBlogsOfUser(ObjectId id){
        Optional<User> optionalUser= userRepo.findById(id);
        if(optionalUser.isPresent()){
            User user=optionalUser.get();
            return user.getBlogsList();
        }
        return null;
    }
    public void editBlog(ObjectId id,Blog newBlog){
            Blog oldBlog= blogRepo.findById(id).orElseThrow(() -> new RuntimeException("Blog not found"));
            oldBlog.setContent(newBlog.getContent());
            oldBlog.setTitle(newBlog.getTitle());
            blogRepo.save(oldBlog);
    }
    public void deleteBlog(ObjectId id){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user =userRepo.findByUsername(username);
        Optional<Blog> blog=blogRepo.findById(id);
        if(blog.isPresent()){
            Blog blogToBeDeleted=blog.get();
            user.getBlogsList().remove(blogToBeDeleted);
            blogRepo.deleteById(id);
            deleteBlogComments(blogToBeDeleted);
            user.setBlogsCount(user.getBlogsCount()-1);
            userRepo.save(user);
        }

    }
    public void deleteBlogComments (Blog blog){
        for(Comments comments:blog.getComments()){
            commentsRepo.deleteById(comments.getId());
        }
    }
}
