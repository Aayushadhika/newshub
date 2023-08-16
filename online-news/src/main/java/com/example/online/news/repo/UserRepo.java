package com.example.online.news.repo;

import com.example.online.news.pojo.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<Users,Integer> {
    public List<Users> findByemail(String email);

}
