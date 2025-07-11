import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-to-do',
  standalone:true,
  imports: [CommonModule, FormsModule,RouterModule],
  templateUrl: './to-do.html',
  styleUrl: './to-do.css'
})
export class ToDo {

}
