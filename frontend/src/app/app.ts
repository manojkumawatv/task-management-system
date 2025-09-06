import { Component, signal, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

// import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  styleUrl: './app.css',
  imports: [CommonModule, FormsModule]
})
export class App implements OnInit {
  protected readonly title = signal('frontend');
  tasks: any[] = [];
  newTaskName: string = '';

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.fetchTasks();
  }

  fetchTasks() {
    this.http.get<any[]>('http://localhost:8765/tasks').subscribe(data => {
      this.tasks = data;
    });
  }

  addTask() {
    if (!this.newTaskName.trim()) return;
    // Optionally, send to backend here
    this.tasks.push({ name: this.newTaskName });
    this.newTaskName = '';
  }
}
