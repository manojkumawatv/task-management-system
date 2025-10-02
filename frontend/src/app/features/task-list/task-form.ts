import { Component, Output, EventEmitter, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Task } from '../../services/task/task.service';

@Component({
  selector: 'app-task-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <form (ngSubmit)="onSubmit()">
      <input [(ngModel)]="task.title" name="title" placeholder="Title" required />
      <textarea [(ngModel)]="task.description" name="description" placeholder="Description"></textarea>
      <input [(ngModel)]="task.dueDate" name="dueDate" type="date" required />
      <select [(ngModel)]="task.status" name="status">
        <option value="TODO">To Do</option>
        <option value="IN_PROGRESS">In Progress</option>
        <option value="DONE">Done</option>
      </select>
      <button type="submit">{{ task.id ? 'Update' : 'Create' }} Task</button>
    </form>
  `
})
export class TaskFormComponent {
  @Input() task: Task = this.getEmptyTask();
  @Output() submitTask = new EventEmitter<Task>();

  onSubmit() {
    this.submitTask.emit(this.task);
    this.task = this.getEmptyTask();
  }

  getEmptyTask(): Task {
    return {
      title: '',
      description: '',
      dueDate: '',
      status: 'TODO',
      projectId: ''
    };
  }
}