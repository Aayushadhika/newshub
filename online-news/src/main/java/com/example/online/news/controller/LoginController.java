package com.example.online.news.controller;

import com.example.online.news.pojo.Users;
import com.example.online.news.repo.UserRepo;
import com.example.online.news.serves.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private Validation validation;
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/logindata")
    public RedirectView logindata(@RequestParam("useremail") String userEmail,@RequestParam("userpassword")String userpassword){
            List<Users> userdata=userRepo.findByemail(userEmail);
            boolean isValid=validation.isValidUser(userdata,userpassword);
        System.out.println(isValid);
            if(isValid){
                return new RedirectView("/home");
            }
        return new RedirectView("/login");

    }

}
