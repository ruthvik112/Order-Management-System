package com.omsauth.api.exceptions;

public class userNotFoundException extends RuntimeException {

	private String message;

    public userNotFoundException() {}

    public userNotFoundException(String msg) {
        super(msg);
        this.message = msg;
    }
}
