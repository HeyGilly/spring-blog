package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {


    // going to redirect you to the index for this post page.
    @GetMapping
    public String allPosts(Model model) {
        List<Post> allPosts = new ArrayList<>();
        Post post1 = new Post("First Post", "This is going to be the body", 1);
        Post post2 = new Post("Second Post", "This is going to be the body", 2);
        Post post3 = new Post("Third Post", "This is going to be the body", 3);
        allPosts.add(post1);
        allPosts.add(post2);
        allPosts.add(post3);
        model.addAttribute("allPosts", allPosts);
        return "post/index";
    }

    @GetMapping("/{id}")
    public String onePosts(@PathVariable long id, Model model){
        Post post1 = new Post("First Post", "This is going to be the body", 1);
        model.addAttribute("id", id);
        model.addAttribute("post", post1);
        return "post/show";
    }

//    @GetMapping("/create")
//    @ResponseBody
//    public String create(){
//        return "";
//    }



}
