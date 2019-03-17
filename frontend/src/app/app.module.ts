import './rxjs-extensions';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { CommonModule } from '@angular/common';

import { AppComponent } from './app.component';
import { NavigationComponent } from './nav/navigation.component';
import { StatsComponent } from './stats/stats.component';
import { ErrorComponent } from './error/error.component';
import { UsersComponent } from './users/users.component';
import { MaterializeModule } from 'angular2-materialize'
import { StatsService } from './stats/stats.service'
import { EmailValidator } from './common/index'

import {
  MembersComponent,
  AddMemberComponent,
  EditMemberComponent,
  AddPaymentComponent,
  DetailsComponent,
  MemberResolverService,
  MemberIdResolverService,
  AllMembersResolverService,
  MemberService,
  PaymentService
} from './members/index';

import { appRoutes } from './routes';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    MembersComponent,
    StatsComponent,
    AddMemberComponent,
    EditMemberComponent,
    AddPaymentComponent,
    DetailsComponent,
    ErrorComponent,
    UsersComponent,
    EmailValidator
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    CommonModule,
    MaterializeModule,
    RouterModule.forRoot(appRoutes, {useHash: true})
  ],
  providers: [
    MemberResolverService,
    MemberIdResolverService,
    AllMembersResolverService,
    MemberService,
    PaymentService,
    StatsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
