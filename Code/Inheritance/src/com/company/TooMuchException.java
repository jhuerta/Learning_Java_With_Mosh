package com.company;

public class TooMuchException extends Exception
{


    public TooMuchException(String message) {
        super("This is toomuch exception: " + message );

    }
}
