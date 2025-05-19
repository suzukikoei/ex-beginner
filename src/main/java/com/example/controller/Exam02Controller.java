package com.example.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {

    @Autowired
    private HttpSession session;

    @GetMapping("")
    public String index(){
        return "exam02";
    }

    @PostMapping("/add")
    public String add(String num1, String num2){
        Integer resultOfAdd = Integer.parseInt(num1) + Integer.parseInt(num2);
        session.setAttribute("num1", Integer.parseInt(num1));
        session.setAttribute("num2", Integer.parseInt(num2));
        session.setAttribute("resultOfAdd", resultOfAdd);
        return "exam02-result";
    }

    @GetMapping("/goResultPage")
    public String goResultPage(){
        return "exam02-result2";
    }

}
