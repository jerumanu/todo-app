package com.example.todoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private  TodoRepository todoRepository ;

    //post

    public TodoClass saveCourse(TodoClass todo) {
        System.out.println(todo.toString());
        return todoRepository.save(todo);
    }
    //Optional!
    public List<TodoClass> saveTodos(List<TodoClass> todos) {
        return todoRepository.saveAll(todos);
    }
    //GET
    public List<TodoClass> getTodos() {
        return todoRepository.findAll();
    }
    public TodoClass getTodoById(int id) {
        return todoRepository.findById(id).orElse(null);
    }
    public TodoClass getTodoByName(String name) {
        return todoRepository.findByName(name);
    }
    public List<TodoClass> getTodosForUser(String username) {
        return todoRepository.findAllByUsername(username);
    }

    //PUT
    public TodoClass updateCourse(TodoClass todo) {
        System.out.println("updates");
        TodoClass existing_todo = todoRepository.findById(todo.getId()).orElse(null);
        existing_todo.setName(todo.getName());
        existing_todo.setDescription(todo.getDescription());
        existing_todo.setStatus(todo.getStatus());
        return todoRepository.save(existing_todo);
    }

    //DELETE
    public String deleteCourse(int id) {
        todoRepository.deleteById(id);
        return id + " id -> todo removed/completed";
    }
}
