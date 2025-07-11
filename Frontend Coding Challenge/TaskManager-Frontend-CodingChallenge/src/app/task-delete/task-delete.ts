import { Component } from '@angular/core';
import { TaskService } from '../task-service';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-task-delete',
  standalone:true,
  imports: [CommonModule, RouterModule, FormsModule],
  templateUrl: './task-delete.html',
  styleUrl: './task-delete.css'
})
export class TaskDelete {

id: number;

  constructor(
    private taskService: TaskService,
    private router: Router
  ) {}

  onDelete() {
    if (!this.id) {
      alert("Please enter a valid ID.");
      return;
    }

    if (confirm("Are you sure you want to delete this task?")) {
      this.taskService.delete(this.id).subscribe({
        next: () => {
          alert("Task deleted!");
          this.router.navigate(['/ToDo', { outlets: { Task: ['TaskList'] } }]);
        },
        error: () => {
          alert("Error deleting task");
        }
      });
    }
  }

}
