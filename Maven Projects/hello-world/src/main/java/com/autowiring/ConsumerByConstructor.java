package com.autowiring;

public class ConsumerByConstructor {
	
	private MessageService messageService;
	
	public ConsumerByConstructor(MessageService messageService) {
		this.messageService = messageService;
	}
	
	public void run() {
		System.out.println("Consumer by Constructor -> "+(messageService == null? "no service" : messageService.sendMessage()));
	}

}
