package com.company;

public class AmountException extends Exception {
    public AmountException(Exception cause) {
        super(cause);
        System.out.println("This is amount exception");
    }
}
