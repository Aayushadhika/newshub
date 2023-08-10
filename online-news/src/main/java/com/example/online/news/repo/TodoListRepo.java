package com.example.online.news.repo;

import com.example.online.news.pojo.TodoList;
import com.example.online.news.pojo.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoListRepo extends CrudRepository<TodoList,Integer> {
    public List<TodoList> findByuserDetails(Users id);
}
