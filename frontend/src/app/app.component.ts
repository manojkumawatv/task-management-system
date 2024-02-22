import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { TaskComponent } from './task/task.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [TaskComponent, CommonModule, RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
}