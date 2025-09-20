import { Routes } from '@angular/router';
import { TaskList } from './features/task-list/task-list';

export const routes: Routes = [
    {path: 'home', component: TaskList},
    {
        path: 'signup',
        loadChildren: () => import('./features/signup/signup-module').then(m => m.SignupModule)
    } //Module Lazy Loading
];

// see app.config.ts