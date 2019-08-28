import { Component, OnInit } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { PrintService } from './service/print.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'Upnxtblog Sample : This is Angular 6 Application';

  constructor( private cookieService: CookieService, 
    public printService: PrintService ) {}

  ngOnInit(): void {
    this.cookieService.set( 'appCookie', 'This is hello apps.' );
    const allCookies = this.cookieService.getAll();
    console.log(allCookies);
  }

  onPrintInvoice() {
    const invoiceIds = ['101', '102'];
    this.printService
      .printDocument('invoice', invoiceIds);
  }
}
