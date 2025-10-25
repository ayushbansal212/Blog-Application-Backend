package com.example.demo.Controller;

import com.example.demo.Entity.Blog;
import com.example.demo.service.BlogService;
import com.example.demo.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/blogs")
public class BlogController {
    @Autowired
    BlogService blogService;
    @GetMapping("get")
    public List<Blog> getAllBlogs(){
        return blogService.getAllBlogs();
    }
    @GetMapping("get/{id}")
    public List<Blog> getAllBlogsOfUser(ObjectId id){
        return blogService.getAllBlogsOfUser(id);
    }
    @PostMapping("addblog")
    public void addBlog(@RequestBody Blog blog){
        blogService.saveBlog(blog);
    }
    @DeleteMapping("delete/{id}")
    public void deleteBlog(@PathVariable ObjectId id){
        blogService.deleteBlog(id);
    }
    @PutMapping("edit/{id}")
    public void editBlog(@PathVariable ObjectId id,@RequestBody Blog blog){
        blogService.editBlog(id,blog);
    }

}
