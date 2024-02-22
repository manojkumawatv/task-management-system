import { Component, OnInit } from '@angular/core';
import { TaskService } from '../task.service';
import { Task } from './task';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-task',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './task.component.html',
  styleUrl: './task.component.css'
})
export class TaskComponent implements OnInit {
  tasks!: any;
  constructor(private taskService: TaskService) { }
  getTasks() {
    this.taskService.getTasks().subscribe({
       next:  tasks => this.tasks = tasks
     })
   }
   ngOnInit() {
     this.getTasks();
   }
}