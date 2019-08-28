import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import { UsersComponent } from './components/users/users.component';

import { RouteResolver } from './resolvers/route.resolver';
import { PrintLayoutComponent } from './components/print-layout/print-layout.component';
import { InvoiceComponent } from './components/invoice/invoice.component';

const routes: Routes = [
  {
    path: 'home', 
    pathMatch: 'full',
    component: HomeComponent
  },
  {
    path: 'users',
    component: UsersComponent,
    resolve: {
      routeResolver: RouteResolver
    },
  },
  {
    path: 'print',
    outlet: 'print',
    component: PrintLayoutComponent,
    children: [
      { path: 'invoice/:invoiceIds', component: InvoiceComponent }
    ]
  },
  {
    path: '**',
    redirectTo: '/',
    pathMatch: 'full'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [RouteResolver]
})

export class AppRoutingModule { }
