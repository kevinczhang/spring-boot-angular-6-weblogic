import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'Upnxtblog Sample : This is Angular 6 Application';

  constructor( private cookieService: CookieService ) {}

  ngOnInit(): void {
    this.cookieService.set( 'appCookie', 'This is hello apps.' );
    const allCookies = this.cookieService.getAll();
    console.log(allCookies);
  }
}
