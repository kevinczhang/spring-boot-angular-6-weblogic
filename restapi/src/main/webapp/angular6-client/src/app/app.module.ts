import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { UsersComponent } from './components/users/users.component';
import { CookieService } from 'ngx-cookie-service';
import { UsersListService } from './service/users-list.service';
import { PrintLayoutComponent } from './components/print-layout/print-layout.component';
import { InvoiceComponent } from './components/invoice/invoice.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UsersComponent,
    PrintLayoutComponent,
    InvoiceComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [ CookieService, UsersListService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
