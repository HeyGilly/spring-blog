package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repository.PostRepository;
import com.codeup.springblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    private PostRepository postsDao;
    //Used for Relationship
    private UserRepository usersDao;

    // when constructor is added, not matching constuctor for autowiring
    @Autowired
    public PostController(PostRepository postsDao, UserRepository usersDao) {
        this.postsDao =  postsDao;
        this.usersDao = usersDao;
    }

    public PostController(PostRepository postsDao){
        this.postsDao = postsDao;
    }


    @GetMapping
    public String allPosts(Model model) {
            // This is array of all post, findAll post does it all
            List<Post> allPosts = postsDao.findAll();
            model.addAttribute("allPosts", allPosts);
        return "post/index";
    }

    // Allow us to see our form
    @GetMapping("/create")
    public String createPost(){
        return"/post/create";
}

    @PostMapping("/create")
    // To pick up parameters from the server side, we need to Request Param by their 'name'
    public String submitPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
        // using the title, body constructor (Post.java) to create a new post object.
        Post post = new Post(title, body);
        // Exercise
        User author = usersDao.getById(1l);
        post.setUser(author);
//        using postDao to use a built-in method "save" post.
        postsDao.save(post);
    // going to redirect you to the index for this post page.
        return "redirect:/post";
    }

    @GetMapping("/{id}")
    public String onePost(@PathVariable long id, Model model){
        Post post = postsDao.findById(id);
        model.addAttribute("post", post);
        return "post/show";
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
