import { Routes } from '@angular/router';
import { AuthGuard } from './auth-guard-guard';
import { Home } from './home/home';
import { UserLogin } from './user-login/user-login';
import { UserRegister } from './user-register/user-register';
import { ToDo } from './to-do/to-do';
import { TaskAdd } from './task-add/task-add';
import { TaskList } from './task-list/task-list';
import { TaskUpdate } from './task-update/task-update';
import { TaskDelete } from './task-delete/task-delete';

export const routes: Routes = [

    { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: Home },
  { path: 'UserLogin', component: UserLogin },
  { path: 'UserRegister', component: UserRegister },
  {path: 'ToDo',component: ToDo,children: [
      { path: '',redirectTo: 'TaskList',pathMatch: 'full'},
      {path: 'TaskList',component: TaskList,outlet: 'Task'},
      {path: 'TaskAdd',component: TaskAdd,outlet: 'Task'},
      {path: 'TaskUpdate',component: TaskUpdate,outlet: 'Task'},
      {path: 'TaskDelete',component: TaskDelete,outlet: 'Task'}
    ]
  },
  // fallback
  { path: '**', redirectTo: '/ToDo' }
     
    ]
;
