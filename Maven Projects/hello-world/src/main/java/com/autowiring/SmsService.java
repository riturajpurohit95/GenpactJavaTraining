package com.autowiring;

public class SmsService implements MessageService{
	
	@Override
	public String sendMessage() {
		return "SMS Sent";
	}

}
