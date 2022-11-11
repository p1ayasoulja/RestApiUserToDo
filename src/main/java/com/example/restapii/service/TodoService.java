package com.example.restapii.service;

import com.example.restapii.entity.TodoEntity;
import com.example.restapii.model.Todo;
import org.springframework.stereotype.Service;

@Service
public interface TodoService {
    Todo createTodo(TodoEntity todoEntity, Long id);

    Todo complete(Long id);
}
