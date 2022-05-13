package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @RequestMapping(path = "/add100To/{number}",  method = RequestMethod.GET)
    @ResponseBody
    public String addOneHundred(@PathVariable int number){
        return number + " add 100 = " + (100 + number);
    }

    // Subtract
    @RequestMapping(path = "/subtract/{num1}/from/{num2}",  method = RequestMethod.GET)
    @ResponseBody
    public String subtraction(@PathVariable int num1, @PathVariable int num2){
        return num2 + " - "+num1+" = " + (num2 - num1);
    }

    //Multiply
    @RequestMapping(path = "/multiply/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String multiplying(@PathVariable int num1, @PathVariable int num2){
        return num1 + " * " + num2 +" = " + (num1*num2);
    }

    //Divide
    @RequestMapping(path="/divide/{num1}/by/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int num1, @PathVariable int num2){
        return  num1 + " / " + num2 + " = " + (num1/num2);
    }






}
