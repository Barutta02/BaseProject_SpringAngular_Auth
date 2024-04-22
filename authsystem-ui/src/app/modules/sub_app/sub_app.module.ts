import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { sub_appRoutingModule } from './sub_app-routing.module';
import { MainComponent } from './pages/main/main.component';

import {FormsModule} from '@angular/forms';



@NgModule({
  declarations: [
    MainComponent,
  ],
  imports: [
    CommonModule,
    sub_appRoutingModule,
    FormsModule
  ]
})
export class sub_appModule { }
