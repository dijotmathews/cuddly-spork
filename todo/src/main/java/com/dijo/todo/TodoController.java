package com.dijo.todo;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/todo/v1")
@RequiredArgsConstructor
@Validated
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/")
    public ResponseEntity<List<Todo>> getAllTodos() {
        return ResponseEntity.ok().body(todoService.getAllTodos());
    }

    @GetMapping("/{id}") 
    public ResponseEntity<Todo> getTodoById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(todoService.getTodoById(id));

    }

    @PostMapping("/")
    public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo) {
        return ResponseEntity.ok().body(todoService.addTodo(todo));

    }

    @PutMapping("/")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo) {
        return ResponseEntity.ok().body(todoService.updateTodo(todo));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable UUID id) {
        todoService.deleteTodoById(id);
        return ResponseEntity.ok().body("Successfully deleted todo");
    }
}
