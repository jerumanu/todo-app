package com.example.todoapp;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class TodoController {

        @Autowired
        private TodoService todoService;
//        private final Logger logger = LoggerFactory.getLogger(TodoController.class);
        //POST
        @PostMapping("/addTodo")
        public TodoClass addCourse(@RequestBody TodoClass todos ){
//            logger.info("Course object {}", todos.toString());
            return todoService.saveCourse(todos);
        }


        @PostMapping("/addTodos")
        public List<TodoClass> addTodos(@RequestBody List<TodoClass> todos) {
            return todoService.saveTodos(todos);
        }

        //GET
        @GetMapping("/todos")
        public List<TodoClass> getAllTodos() {
            return todoService.getTodos();
        }
        @GetMapping("/todosById/{id}")
        public TodoClass findTodobyId(@PathVariable int id) {
            return todoService.getTodoById(id);
        }
        @GetMapping("/todoByName/{name}")
        public TodoClass findTodosbyName(@PathVariable String name) {
            return todoService.getTodoByName(name);
        }
        @GetMapping("/listTodosbyUsername/{username}")
        public List<TodoClass> findTodosByUsername(@PathVariable String username) {
            return todoService.getTodosForUser(username);
        }

        //PUT
        @PutMapping("/update")
        public TodoClass updateCourse(@RequestBody TodoClass todos)
        {
            System.out.println("UPDATED");
            return todoService.updateCourse(todos);
        }


        //DELETE
        @DeleteMapping("/delete/{id}")
        public String deleteCourse(@PathVariable int id) {
            return todoService.deleteCourse(id);
        }

    }

