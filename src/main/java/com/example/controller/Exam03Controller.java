package com.example.controller;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Exam03Controller {

    @Autowired
    private ServletContext application;

    @GetMapping("")
    public String index(){
        return "exam03";
    }

    @PostMapping("/sumPrice")
    public String sumPrice(String itemPrice1, String itemPrice2, String itemPrice3){
        Integer sumPrice = Integer.parseInt(itemPrice1) + Integer.parseInt(itemPrice2) + Integer.parseInt(itemPrice3);

        Integer sumPriceIncludeTax = (int) (sumPrice * 1.1);
        application.setAttribute("sumPrice", sumPrice);
        application.setAttribute("sumPriceIncludeTax", sumPriceIncludeTax);
        return "exam03-result";
    }

}
