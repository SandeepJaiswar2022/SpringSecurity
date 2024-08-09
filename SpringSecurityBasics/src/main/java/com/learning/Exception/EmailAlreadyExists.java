package com.learning.Exception;

public class EmailAlreadyExists extends Throwable {
    public EmailAlreadyExists(String msg) {
        super(msg);
    }
}
