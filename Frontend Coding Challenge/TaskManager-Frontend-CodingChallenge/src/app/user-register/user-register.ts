import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';

import { User } from '../user';                // ← your class‑based model
import { UserService } from '../user-service'; // ← wraps /auth endpoints

@Component({
  selector: 'app-user-register',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './user-register.html',
  styleUrl: './user-register.css'
})
export class UserRegister {

  user: User = new User();        // two‑way bound to the form
  loading = false;

  constructor(private api: UserService, private router: Router) {}

  register(f: NgForm) {
    if (f.invalid) { return; }

    this.loading = true;
    this.api.register(this.user).subscribe({
      next: () => {
        alert('User registered successfully!');
        this.router.navigate(['/UserLogin']);   // go to login page
      },
      error: err => {
        this.loading = false;
        alert(err.error || 'Registration failed (username may exist).');
      }
    });
  }
}
