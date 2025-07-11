import { Component, OnInit } from '@angular/core';
import { Task } from '../task';
import { TaskService } from '../task-service';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-task-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './task-list.html',
  styleUrl: './task-list.css'
})
export class TaskList implements OnInit {

  tasks: Task[] = [];

  constructor(private taskService: TaskService, private router: Router) {}

  ngOnInit(): void {
    this.taskService.getAll().subscribe({
      next: (data) => this.tasks = data,
      error: () => alert("Failed to fetch tasks.")
    });
  }

  updateTask(id: number) {
    this.router.navigate(['/ToDo', { outlets: { Task: ['TaskUpdate', id] } }]);
  }

  addTask() {
    this.router.navigate(['/ToDo', { outlets: { Task: ['TaskAdd'] } }]);
  }


  deleteTask(id: number) {
  this.router.navigate(
    ['/ToDo', { outlets: { Task: ['TaskDelete'], id } }],  // optional if you want id param
  );
}
}
