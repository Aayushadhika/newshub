package com.example.online.news.controller;

import com.example.online.news.pojo.TodoList;
import com.example.online.news.pojo.Users;
import com.example.online.news.repo.TodoListRepo;
import com.example.online.news.repo.UserRepo;
import com.example.online.news.serves.Validation;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private TodoListRepo todoListRepo ;
@Autowired
private UserRepo userRepo;
@Autowired
private Validation validation;
@GetMapping("/home")
    public String home(Model model, HttpSession session){
    String userEmail=(String) session.getAttribute("useremail");
    String userPassword=(String) session.getAttribute("userpassword");
    List<Users>  emailData=userRepo.findByemail(userEmail);
    Users userData=validation.getUser(emailData,userPassword);

    List<TodoList> fetchedData=todoListRepo.findByuserDetails(userData);
    model.addAttribute("taskList",fetchedData);

    return "home";
}
@GetMapping("/delete/{listId}")
public RedirectView deleteList(@PathVariable String listId){
    int id=Integer.parseInt(listId);
    todoListRepo.deleteById(id);
    return new RedirectView("/home");

}

}
