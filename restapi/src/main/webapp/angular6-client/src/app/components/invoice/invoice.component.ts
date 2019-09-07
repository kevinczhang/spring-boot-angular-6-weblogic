import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PrintService } from 'src/app/service/print.service';
import { ChatService } from 'src/app/service/chat.service';
import { ChatMessage } from 'src/app/models/chat-message';

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.css']
})
export class InvoiceComponent implements OnInit {

  invoiceIds: string[];
  invoiceDetails: Promise<any>[];
  chatHistory: ChatMessage[];

  constructor(route: ActivatedRoute, private printService: PrintService,
    chatService: ChatService) {
    this.invoiceIds = route.snapshot.params['invoiceIds'].split(',');
    this.chatHistory = chatService.getChatHistory();
  }

  ngOnInit() {
    // this.invoiceDetails = this.invoiceIds
    //   .map(id => this.getInvoiceDetails(id));
    // Promise.all(this.invoiceDetails)
    //   .then(() => this.printService.onDataReady());
    this.printService.onDataReady();
  }

  getInvoiceDetails(invoiceId) {
    const amount = Math.floor((Math.random() * 100));
    return new Promise(resolve =>
      setTimeout(() => resolve({amount}), 1000)
    );
  }

}
