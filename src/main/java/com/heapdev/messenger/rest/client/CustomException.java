package com.heapdev.messenger.rest.client;

public class CustomException extends Exception {
	public CustomException(String ex) {
		System.out.println(ex);
	}
}
