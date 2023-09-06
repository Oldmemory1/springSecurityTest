package com.example.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class HelloController {
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model){
        if("test".equals(username)&&"123456".equals(password)){
            session.setAttribute("login",true);
            return "redirect:/";
        }else {
            model.addAttribute("status",true);
            return "login";
        }
    }
    @GetMapping("/")
    public String index(HttpSession session){
        if (session.getAttribute("login")!=null){
            return "index";
        }else {
            return "login";
        }
    }
}
