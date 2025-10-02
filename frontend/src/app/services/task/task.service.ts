import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Task {
  id?: string;
  title: string;
  description: string;
  dueDate: string;
  status: string;
  projectId: string;
  userId?: string;
}

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  private apiUrl = 'https://task-backend-759506146108.asia-south1.run.app/tasks';

  constructor(private http: HttpClient) {}

  // CREATE
  createTask(task: Task): Observable<string> {
    return this.http.post<string>(this.apiUrl, task);
  }

  // READ - All tasks
  getAllTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(this.apiUrl);
  }

  // READ - By user
  getTasksByUserId(userId: number): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.apiUrl}/${userId}`);
  }

  // READ - By ID
  getTaskById(id: string): Observable<Task> {
    return this.http.get<Task>(`${this.apiUrl}/task/${id}`);
  }

  // UPDATE
  updateTask(id: string, task: Task): Observable<string> {
    return this.http.put<string>(`${this.apiUrl}/${id}`, task);
  }

  // DELETE
  deleteTask(id: string): Observable<string> {
    return this.http.delete<string>(`${this.apiUrl}/${id}`);
  }
}