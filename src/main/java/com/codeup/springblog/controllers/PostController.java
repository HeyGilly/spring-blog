package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {


    private PostRepository postsDao;

    public PostController(PostRepository postsDao){
        this.postsDao = postsDao;
    }

    // going to redirect you to the index for this post page.
    @GetMapping
    public String allPosts(Model model) {
        List<Post> allPosts = new ArrayList<>();
        Post post1 = new Post(1, "First Post", "This is going to be the body");
        Post post2 = new Post(2, "Second Post", "This is going to be the body");
        Post post3 = new Post(3, "Third Post", "This is going to be the body");
        allPosts.add(post1);
        allPosts.add(post2);
        allPosts.add(post3);
        model.addAttribute("allPosts", allPosts);
        return "post/index";
    }

    @GetMapping("/{id}")
    public String onePosts(@PathVariable long id, Model model){
        Post post1 = new Post(1, "First Post", "This is going to be the body");
        model.addAttribute("id", id);
        model.addAttribute("post", post1);
        return "post/show";
    }

@GetMapping("/create")
    public String createPost(){
        return"post/create";
}



}
