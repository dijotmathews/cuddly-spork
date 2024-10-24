package com.dijo.todo;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class TodoService {
    private final TodoRepo todoRepo;

    public List<Todo> getAllTodos(){
        return todoRepo.findAll();
    }

    public Todo getTodoById(UUID id) {
        Optional<Todo> optionalTodo = todoRepo.findById(id);
        if(optionalTodo.isPresent()) {
            return optionalTodo.get();
        }
        log.info("Todo with id: {} doesn't exist", id);
        return null;
    }

    public Todo addTodo(Todo todo) {
        todo.setCreateAt(LocalDateTime.now());
        todo.setUpdateAt(LocalDateTime.now());

        Todo savedTodo = todoRepo.save(todo);

        log.info("Todo with id {} saved successfully", todo.getId());
        return savedTodo;

    }

    public Todo updateTodo(Todo todo) {
        Optional<Todo> existingTodo = todoRepo.findById(todo.getId());
        todo.setCreateAt(existingTodo.get().getCreateAt());
        todo.setUpdateAt(LocalDateTime.now());

        Todo updateTodo = todoRepo.save(todo);
        log.info("Todo with id {} updated successfully.", todo.getId() );

        return updateTodo;
    }

    public void deleteTodoById(UUID id) {
        todoRepo.findById(id);
    }

    
}
