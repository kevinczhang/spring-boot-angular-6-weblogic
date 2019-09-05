import { Component, OnInit, HostListener, ElementRef } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { PrintService } from './service/print.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'Upnxtblog Sample : This is Angular 6 Application';
  showMenu = false;

  constructor( private cookieService: CookieService, 
    public printService: PrintService, private eRef: ElementRef) {}

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

  showDropdown(event: Event) {
    event.stopPropagation();
    this.showMenu = !this.showMenu;
  }

  @HostListener('document:click', ['$event']) clickout(event) {
    event.stopPropagation();
    this.showMenu = false;
  }

}
