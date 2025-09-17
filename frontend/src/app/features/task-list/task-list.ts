import { Component, Input, Output, EventEmitter, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';


export interface Task {
  id: string;
  title: string;
  description: string;
  dueDate: string;
  status: string;
  projectId: string;
}

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.html',
  styleUrls: ['./task-list.css'],
  imports: [CommonModule]
})
export class TaskList implements OnInit {
  protected readonly title = signal('frontend');
  public newTaskName: string = '';

  constructor(private http: HttpClient) {}
  ngOnInit() {
    this.fetchTasks();
  }
  public fetchTasks() {
    this.http.get<Task[]>('https://task-backend-759506146108.asia-south1.run.app/tasks').subscribe(data => {
      this.tasks = data;
    });
  }

  @Input() tasks: Task[] = [];
  @Output() deleteTask = new EventEmitter<string>();

  onDeleteTask(taskId: string) {
    this.deleteTask.emit(taskId);
  }
  

  
}