package com.company;

import com.company.Point.Point;
import com.company.TextBox.TextBox;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws AmountException {
//	var control = new TextBox();

//        var a = new Point(3,5);
//        var b = new Point(3,5);
//        try {
//            var areEqual = a.exMethod(null);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            throw new AmountException(new TooMuchException("The Amount Excetpion"));
        }
        catch (Exception ex )
        {
            System.out.println("the catch block");
            System.out.println(ex.getCause().getMessage());
        }


//        System.out.println(a.equals(b));
//        System.out.println(a==b);


    }
}


