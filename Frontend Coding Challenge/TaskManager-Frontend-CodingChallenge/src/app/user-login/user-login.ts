import { Component } from '@angular/core';
import { User } from '../user';
import { Router, RouterModule } from '@angular/router';
import { FormsModule, NgForm } from '@angular/forms';
import { UserService } from '../user-service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-user-login',
  standalone:true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './user-login.html',
  styleUrl: './user-login.css'
})
export class UserLogin {

  
  user: User;
  isValid: boolean;

  constructor(private _router: Router, private _userService: UserService) {
    this.user = new User();
    this.isValid = false;
  }

  login(loginForm: NgForm) {
    this.isValid = false;
    if (loginForm.invalid) {
      return;
    }

    this.isValid = true;
    this._userService.login(this.user.username, this.user.password).subscribe({
      next: (token: string) => {
        localStorage.setItem("token", token);
        // Navigate to the dashboard or task list page
        this._router.navigate(['/ToDo', { outlets: { Task: ['TaskList'] } }]);

      },
      error: () => {
        alert("Invalid Credentials...");
      }
    });
  }
}
