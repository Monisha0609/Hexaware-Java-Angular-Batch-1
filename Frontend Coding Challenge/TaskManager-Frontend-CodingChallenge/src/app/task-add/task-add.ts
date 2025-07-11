import { Component } from '@angular/core';
import { Task } from '../task';
import { Priority } from '../priority';
import { Status } from '../status';
import { TaskService } from '../task-service';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-task-add',
  standalone:true,

  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './task-add.html',
  styleUrl: './task-add.css'
})
export class TaskAdd {

  task: Task = new Task();

  constructor(private taskService: TaskService, private router: Router) {}

  save(form: NgForm) {
    if (form.invalid) return;

    this.taskService.create(this.task).subscribe(() => {
      alert('Task added!');
      this.router.navigate(['/ToDo', { outlets: { Task: ['TaskList'] } }]);
    });
  }

}
