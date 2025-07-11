import { Component, OnInit } from '@angular/core';
import { Task } from '../task';
import { Priority } from '../priority';
import { Status } from '../status';
import { TaskService } from '../task-service';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-task-update',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './task-update.html',
  styleUrl: './task-update.css'
})
export class TaskUpdate implements OnInit {

  task: Task = new Task();
  id!: number;
  priorities = Object.values(Priority);
  statuses = Object.values(Status);

  constructor(
    private taskService: TaskService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
  this.route.paramMap.subscribe(pm => {
    this.id = +pm.get('id')!;
    this.taskService.getById(this.id).subscribe(t => this.task = t);
  });
}

  updateTask(form: NgForm) {
    if (form.invalid) return;

    this.taskService.update(this.id, this.task).subscribe(() => {
      alert("Task updated!");
      this.router.navigate(['/ToDo', { outlets: { Task: ['TaskList'] } }]); // <- Correct routing
    });
  }

}
