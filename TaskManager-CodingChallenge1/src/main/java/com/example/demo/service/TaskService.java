package com.example.demo.service;

import com.example.demo.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findTasksByUsername(String username);
    Task saveTaskForUser(Task task, String username);
    void deleteTaskByIdForUser(int id, String username);
    List<Task> getAllTasks();
    Optional<Task> getTaskById(int id);
    Task updateTask(Task task, int taskId, String username);
}