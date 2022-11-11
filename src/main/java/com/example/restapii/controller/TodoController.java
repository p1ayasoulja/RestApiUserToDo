package com.example.restapii.controller;

import com.example.restapii.entity.TodoEntity;
import com.example.restapii.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
   private TodoService todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo,
                                     @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(todoService.createTodo(todo, userId));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Exception!!!Attention!!!");
        }

    }

    @PutMapping
    public ResponseEntity checkTodo(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(todoService.complete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Exception!!!Attention!!!");
        }

    }
}
