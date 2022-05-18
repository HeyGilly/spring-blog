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


    private final PostRepository postsDao;

    public PostController(PostRepository postsDao){
        this.postsDao = postsDao;
    }


    // going to redirect you to the index for this post page.
    @GetMapping
    public String allPosts(Model model) {
            List<Post> allPosts = postsDao.findAll();
            model.addAttribute("allPosts", allPosts);
        return "post/index";
    }

    @GetMapping("/create")
    public String createPost(){
        return"/post/create";
}

    @PostMapping("/create")
    // action formwas incorrect
    // no constructor

    public String submitPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
        Post post = new Post(title, body);
        postsDao.save(post);
        return "redirect:/post";
    }

////---------- OLD Material

    //    public List<Post> generatePosts(){
//        List<Post> allPosts = new ArrayList<>();
//        Post post1 = new Post(1, "First Post", "This is going to be the body");
//        Post post2 = new Post(2, "Second Post", "This is going to be the body");
//        Post post3 = new Post(3, "Third Post", "This is going to be the body");
//        allPosts.add(post1);
//        allPosts.add(post2);
//        allPosts.add(post3);
//        return allPosts;
//    }

    //    @GetMapping("/{id}")
//    public String onePost(@PathVariable long id, Model model){
//        List<Post> allPosts = generatePosts();
//        Post post = null;
//        for (int i = 0; i<allPosts.size(); i++){
//            if(allPosts.get(i).getId() == id){
//                post = allPosts.get(i);
//            }
//        }
//        model.addAttribute("post", post);
//        return "post/show";
//    }



}
