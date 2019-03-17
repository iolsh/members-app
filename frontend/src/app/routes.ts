import { Routes } from '@angular/router';
import { MembersComponent, AddMemberComponent, DetailsComponent, AllMembersResolverService, MemberResolverService, MemberIdResolverService, EditMemberComponent, AddPaymentComponent} from './members/index';
import { StatsComponent } from './stats/stats.component';
import { ErrorComponent } from './error/error.component';
import { UsersComponent} from './users/users.component';

export const appRoutes: Routes = [
  { path: 'members', component: MembersComponent, resolve: {members: AllMembersResolverService}},
  { path: 'members/add', component: AddMemberComponent},
  { path: 'members/edit/:id', component: EditMemberComponent, resolve: {member: MemberResolverService}},
  { path: 'members/pay/:memberId', component: AddPaymentComponent, resolve: {mid: MemberIdResolverService}},
  { path: 'members/:id', component: DetailsComponent, resolve: {member: MemberResolverService}},
  { path: 'stats', component: StatsComponent},
  { path: 'error', component: ErrorComponent},
  { path: 'login', component: UsersComponent},
  { path: '', redirectTo: 'members', pathMatch: 'full'}
];
