package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;


// Defines that our class is controller
@Controller
//This is added to make this code look cleaner
@RequestMapping("/hello")
public class HelloController {

    // List of Arrays
    private final String[] names = {"Omar", "Mateo", "Liam", "Emma", "Reem", "Sofia", "James", "Agustin", "Antonella", "Youssef", "Abigail", "Zahra"};

    // Defines a method that should be invoked when a GET request is received for the specified URL
    @GetMapping()
    // Tells spring that whatever is returned from this method should be the body of our response

    @ResponseBody
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/{name}")
    @ResponseBody
    //  PATH VARIABLES, that is, variables that are part of the URI of a request,
    // as opposed to being passed as a query string, or as part of the request body.
    public String sayHello(@PathVariable String name){
        return "Hello " + name + "!";
    }

    public String randomGreeting(){
        int rnd = new Random().nextInt(names.length);
        return "Hello " + names[rnd] + "!";
    }

    @GetMapping("/{name1}/{name2}")
    @ResponseBody
    public String greetTwo(@PathVariable String name1, @PathVariable String name2){
        return "Hello, " + name1 +  " and " + name2 + "!";
    }

    @GetMapping("{name1}/to/{namem2}")
    @ResponseBody
    public String oneGreetAnother(@PathVariable String name1, @PathVariable String name2){
        return name1 + " says hello to " + name2;
    }


    // Not Really USed Earlier Version of Mapping in Spring
//    @RequestMapping(path = "/add100To/{number}", method = RequestMethod.GET)
//    public String addOneHundred(@PathVariable int number){
//        return number + "+ 100 =" + (number + 100);
//    }


    @GetMapping("/test")
    public String viewTest(){
        return "view-lecture/test";
    }



}
