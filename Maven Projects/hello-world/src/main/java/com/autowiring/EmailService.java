package com.autowiring;

public class EmailService implements MessageService {
	
	@Override
	public String sendMessage() {
		return "Email Sent";
	}

}
