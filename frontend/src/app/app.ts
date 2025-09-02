import { Component, signal, OnInit, NgModule} from '@angular/core';
import { HttpClient } from '@angular/common/http';
// import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  // imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');
  tasks: any[] = [];
  newTaskName: String = '';
  constructor(private http: HttpClient){}
  ngOnInit(){
    this.fetchTasks();
  }
  fetchTasks() {
    this.http.get<any[]>('http://localhost:8765/tasks').subscribe(data => {
      this.tasks = data;
    });
  }
}
