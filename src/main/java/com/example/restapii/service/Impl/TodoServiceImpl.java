package com.example.restapii.service.Impl;

import com.example.restapii.entity.TodoEntity;
import com.example.restapii.entity.UserEntity;
import com.example.restapii.model.Todo;
import com.example.restapii.repo.TodoRepo;
import com.example.restapii.repo.UserRepo;
import com.example.restapii.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    TodoRepo todoRepo;
    @Autowired
    UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long id) {
        UserEntity user = userRepo.findById(id).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));

    }

    public Todo complete(Long id) {
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));

    }
}
