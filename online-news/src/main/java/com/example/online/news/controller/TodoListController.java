package com.example.online.news.controller;

import com.example.online.news.pojo.TodoList;
import com.example.online.news.pojo.Users;
import com.example.online.news.repo.TodoListRepo;
import com.example.online.news.repo.UserRepo;
import com.example.online.news.serves.Validation;
import jakarta.persistence.Entity;
import jakarta.servlet.http.HttpSession;
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
    private Validation validation;
    @Autowired
    private TodoListRepo todoListRepo;
    @Autowired
    private UserRepo userRepo;
    @PostMapping("/tododata")
    public String  insertTodoData(@RequestParam("title")String title, @RequestParam("description") String description, @RequestParam("timing") String timing, @RequestParam("importance") String importance, Model model, HttpSession session){
       TodoList data=new TodoList();
       data.setTaskTitle(title);
       data.setTaskDescription(description);
       data.setTaskTiming(timing);
       data.setTaskImportance(importance);
       String userEmail=(String) session.getAttribute("useremail");
       String userPassword=(String) session.getAttribute("userpassword");
       List<Users>  emailData=userRepo.findByemail(userEmail);
       Users userData=validation.getUser(emailData,userPassword);
        data.setUserDetails(userData);
       todoListRepo.save(data);
        List<TodoList> fetchedData=todoListRepo.findByuserDetails(userData);
        model.addAttribute("taskList",fetchedData);
        return "/home";


    }
//    @GetMapping("/getSession")
//    public Object getSession(HttpSession session){
//        System.out.println(session.getAttribute("useremail"));
//     return session.getAttribute("useremail");
//
//    }

}
