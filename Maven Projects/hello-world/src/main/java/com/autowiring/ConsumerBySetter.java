package com.autowiring;

public class ConsumerBySetter {
	
	private MessageService messageService;
	
	//setter method - autowiring - byname or bytype
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	
	public void run() {
		System.out.println("Consumer by Setter -> "+(messageService == null? "no service" : messageService.sendMessage()));
	}

}
