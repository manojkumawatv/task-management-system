import { Component, OnInit, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TaskService, Task } from '../../services/task/task.service';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.html',
  styleUrls: ['./task-list.css'],
  imports: [CommonModule],
  standalone: true
})
export class TaskList implements OnInit {
  protected readonly title = signal('frontend');
  public tasks: Task[] = [];
  public isLoading = false;

  constructor(private taskService: TaskService) {}

  ngOnInit() {
    this.fetchTasks();
  }

  // READ - Fetch all tasks
  fetchTasks() {
    this.taskService.getAllTasks().subscribe({
      next: (data) => {
        this.tasks = data;
        this.isLoading = false;
      },
      error: (err) => {
        console.error('Error fetching tasks:', err);
        this.isLoading = false;
      }
    });
  }

  // CREATE - Add new task
  addTask(task: Task) {
    this.taskService.createTask(task).subscribe({
      next: (response) => {
        console.log('Task created:', response);
        this.fetchTasks(); // Refresh list
      },
      error: (err) => console.error('Error creating task:', err)
    });
  }

  // UPDATE - Edit existing task
  updateTask(id: string, task: Task) {
    this.taskService.updateTask(id, task).subscribe({
      next: (response) => {
        console.log('Task updated:', response);
        this.fetchTasks(); // Refresh list
      },
      error: (err) => console.error('Error updating task:', err)
    });
  }

  // DELETE - Remove task
  deleteTask(taskId: string) {
    if (confirm('Are you sure you want to delete this task?')) {
      this.taskService.deleteTask(taskId).subscribe({
        next: (response) => {
          console.log('Task deleted:', response);
          this.tasks = this.tasks.filter(task => task.id !== taskId);
        },
        error: (err) => console.error('Error deleting task:', err)
      });
    }
  }
}