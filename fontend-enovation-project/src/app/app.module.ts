import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from "@angular/router";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MessageComponent } from './message/message.component';
import { UserComponent } from './user/user.component';
import { UserService } from "./user/service/user.service";
import { MessageService } from "./message/service/message.service";
import { HttpClientModule } from "@angular/common/http";
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";


@NgModule({
  declarations: [
    AppComponent,
    MessageComponent,
    UserComponent,
  ],

  imports: [
    BrowserModule,
    HttpClientModule,
    CommonModule,
    FormsModule,
    AppRoutingModule,
    RouterModule.forRoot([
     {path: 'users', component: UserComponent},
     {path: 'messages', component: MessageComponent},
     {path: 'message/:id', component: MessageComponent},
     ]),
  ],

   exports: [RouterModule,
     FormsModule,
     CommonModule,
     ReactiveFormsModule,],
  providers: [UserService, MessageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
