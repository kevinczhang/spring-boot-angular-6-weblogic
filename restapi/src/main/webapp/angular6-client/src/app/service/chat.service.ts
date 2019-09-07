import { Injectable } from "@angular/core";
import { ChatMessage } from "../models/chat-message";

@Injectable({
  providedIn: "root"
})
export class ChatService {

  chatHistory: ChatMessage[] = [];

  constructor() {
    const newMessage = new ChatMessage('BOA', 'Hello from BOA');
    this.chatHistory.push(newMessage);
    this.chatHistory.push(new ChatMessage('User', 'Hello from User'));
    this.chatHistory.push(new ChatMessage('BOA', 'How can I help ?'));
    this.chatHistory.push(new ChatMessage('User', 'Nothing'));
  }

  getChatHistory() {
    return this.chatHistory;
  }
}
