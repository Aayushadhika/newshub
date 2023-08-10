package com.example.online.news.serves;

import com.example.online.news.pojo.Users;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class Validation {
    public boolean isValidUser(List<Users> users,String password){
          for(Users data:users){
              if(data.getPassword().equals(password)){
                  return true;
              }
          }
          return false;
    }
}
