package com.example.online.news.controller;

import com.example.online.news.pojo.TodoList;
import com.example.online.news.pojo.Users;
import com.example.online.news.repo.TodoListRepo;
import com.example.online.news.repo.UserRepo;
import jakarta.persistence.Entity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class TodoListController {
    @Autowired
    private TodoListRepo todoListRepo;
    @Autowired
    private UserRepo userRepo;
    @PostMapping("/tododata")
    public String insertTodoData(@RequestParam("title")String title, @RequestParam("description") String description, @RequestParam("timing") String timing, @RequestParam("importance") String importance, Model model){
       TodoList data=new TodoList();
       data.setTaskTitle(title);
       data.setTaskDescription(description);
       data.setTaskTiming(timing);
       data.setTaskImportance(importance);
       Users user=userRepo.findById(1).orElse(null);
       data.setUserDetails(user);
       todoListRepo.save(data);
       List<TodoList> fetchedData=todoListRepo.findByuserDetails(user);
       model.addAttribute("taskList",fetchedData);
       return "/home";





    }
}
