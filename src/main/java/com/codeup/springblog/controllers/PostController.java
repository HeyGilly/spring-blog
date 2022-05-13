package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/post")
public class PostController {

    @GetMapping()
    @ResponseBody
    public String posts(){
        return "All post are here!";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String allPosts(@PathVariable long id){
        return "Here is post number " + id;
    }

    @GetMapping("/create")
    @ResponseBody
    public String create(){
        return "";
    }



}
