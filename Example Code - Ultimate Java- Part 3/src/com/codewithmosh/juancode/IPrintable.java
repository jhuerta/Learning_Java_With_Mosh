package com.codewithmosh.juancode;

public interface IPrintable {

    void print(String message);
    default void println(String message, String suffix)
    {
        System.out.println("* " + message + " - " + suffix + " *");
    }
}
