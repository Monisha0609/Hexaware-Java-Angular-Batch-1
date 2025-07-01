package com.example.demo.repo;

import com.example.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByUserId(int userId);
}