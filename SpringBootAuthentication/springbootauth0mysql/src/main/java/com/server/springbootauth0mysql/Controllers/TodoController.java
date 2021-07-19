package com.server.springbootauth0mysql.Controllers;

import javax.persistence.EntityNotFoundException;

import com.server.springbootauth0mysql.Entities.Todos;
import com.server.springbootauth0mysql.Repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    // Get all todos
    @GetMapping("/get_todo")
    public Iterable<Todos> getTodos() {
        return todoRepository.findAll();
    }

    // Find a todo by ID
    @GetMapping("/todo/{id}")
    public Todos findTodoById(@PathVariable Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Unable to find Todo Id: " + id));
    }

    // Add a new todo
    @PostMapping("/add_todo")
    public ResponseEntity<Object> addTodo(@RequestBody Todos newTodo) {
        todoRepository.save(newTodo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Delete a todo
    @DeleteMapping("/delete_todo/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
        todoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // Update a Todo
    @PutMapping("/update_todo/{id}")
    public ResponseEntity<Todos> updateTodoAuthor(@PathVariable Long id, @RequestBody Todos updatedTodo) {
        Todos todoAuthor = todoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Unable to find Todo Id: " + id));

        todoAuthor.setAuthor(updatedTodo.getAuthor());
        todoAuthor.setCompleted(updatedTodo.getCompleted());
        todoAuthor.setTodo(updatedTodo.getTodo());
        final Todos finalUpdatedTodo = todoRepository.save(todoAuthor);
        return ResponseEntity.ok(finalUpdatedTodo);
    }
}
