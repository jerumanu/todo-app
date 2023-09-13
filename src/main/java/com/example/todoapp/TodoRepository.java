package com.example.todoapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoClass, Integer> {
    TodoClass findByName(String name);

    List<TodoClass> findAllByUsername(String username);

}
