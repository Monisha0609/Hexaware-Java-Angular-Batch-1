package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.entity.User;
import com.example.demo.repo.TaskRepository;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public List<Task> findTasksByUsername(String username) {
        User user = userRepo.findByUsername(username).orElseThrow();
        return taskRepo.findAll().stream()
                .filter(task -> task.getUser().getId() == user.getId())
                .toList();
    }

    @Override
    public Task saveTaskForUser(Task task, String username) {
        User user = userRepo.findByUsername(username).orElseThrow();
        task.setUser(user);
        return taskRepo.save(task);
    }

    @Override
    public void deleteTaskByIdForUser(int id, String username) {
        Task task = taskRepo.findById(id).orElseThrow();
        if (task.getUser().getUsername().equals(username)) {
            taskRepo.deleteById(id);
        } else {
            throw new SecurityException("Not authorized to delete this task.");
        }
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    @Override
    public Optional<Task> getTaskById(int id) {
        return taskRepo.findById(id);
    }

    @Override
    public Task updateTask(Task updatedTask, int taskId, String username) {
        Task task = taskRepo.findById(taskId).orElseThrow();
        if (!task.getUser().getUsername().equals(username)) {
            throw new SecurityException("You do not have permission to update this task.");
        }

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setDueDate(updatedTask.getDueDate());
        task.setPriority(updatedTask.getPriority());
        task.setStatus(updatedTask.getStatus());

        return taskRepo.save(task);
    }
}
