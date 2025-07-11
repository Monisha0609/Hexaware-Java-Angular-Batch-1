import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone:true,
  imports: [CommonModule,RouterModule,FormsModule],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {

}
