package com.codewithmosh.juancode;

public class PhysicalPrinter implements IPrintable {



    @Override
    public void print(String message) {
        System.out.println("Print: " + message);
    }
}
