import { Routes } from '@angular/router';
import { TaskList } from './features/task-list/task-list';

export const routes: Routes = [
    {path: 'home', component: TaskList}
];

// see app.config.ts