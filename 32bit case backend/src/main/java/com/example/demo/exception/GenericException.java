package com.example.demo.exception;

public class GenericException extends RuntimeException {
	public GenericException(String exMessage) {
		super(exMessage);
	}
	
	public GenericException(String exMessage, Exception exception) {
		super(exMessage,exception);
	}
}
