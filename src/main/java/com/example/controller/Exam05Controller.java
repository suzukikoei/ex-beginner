package com.example.controller;


import com.example.domain.Member;
import com.example.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/exam05")
public class Exam05Controller {

    @Autowired
    private MemberRepository repository;

    @GetMapping("")
    public String index(){
        return "exam05";
    }

    @PostMapping("/search")
    public String search(String partOfName, Model model){
        List<Member> members = repository.findByName(partOfName);
        model.addAttribute("members", members);
        System.out.println(partOfName);
        System.out.println(members);
        return "exam05-result";
    }

}
