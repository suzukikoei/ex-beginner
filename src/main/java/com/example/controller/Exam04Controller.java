package com.example.controller;

import com.example.Form.UserForm;
import com.example.domain.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
    @GetMapping("")
    public String index(UserForm userForm){
        return "exam04";
    }

    @PostMapping("/resister")
    public String resister(
            @Validated UserForm form
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes
            ){

        if(bindingResult.hasErrors()){
            return index(form);
        }

        ModelMapper modelMapper = new ModelMapper();
        //        form オブジェクトの内容を User クラスのインスタンスに変換して、user という変数に代入
        User user = modelMapper.map(form, User.class);

        redirectAttributes.addFlashAttribute("user", user);

        return "redirect:/exam04/exam04-result";
    }

    @GetMapping("/exam04-result")
    public String getResult(){
        return "exam04-result";
    }
}
