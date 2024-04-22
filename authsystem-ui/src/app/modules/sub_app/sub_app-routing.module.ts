import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {authGuard} from '../../services/guard/auth.guard';
import { MainComponent } from './pages/main/main.component';

const routes: Routes = [
  {
    path: '',
    component: MainComponent,
    canActivate: [authGuard],
    children: [
     /* {
        path: '',
        component: BookListComponent,
        canActivate: [authGuard]
      },
      {
        path: 'my-books',
        component: MyBooksComponent,
        canActivate: [authGuard]
      }*/
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class sub_appRoutingModule {
}
