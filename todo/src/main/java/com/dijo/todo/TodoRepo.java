package com.dijo.todo;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo  extends JpaRepository<Todo, UUID> {
    
}
