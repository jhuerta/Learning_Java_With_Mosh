package com.company;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//    dataTypes();
//    arraysAndBeyond();
//    matrix();
//    constants();
//        readingInput();
        projectMortgteCalculator();
    }

    private static void projectMortgteCalculator()
    {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: " );
        var principal = scanner.nextDouble();

        System.out.print("Annual Interest Rate: " );
        var annualInterestRate = scanner.nextDouble();

        System.out.print("Period (years) " );
        var years = scanner.nextInt();

        var annualInterestRatePercentual = annualInterestRate/100/12;
        var interestPlusOneToN = Math.pow(1 + annualInterestRate, years*12);

        var monthlyMortgage = principal* annualInterestRatePercentual * interestPlusOneToN/(interestPlusOneToN - 1);
        System.out.print("Mortgage :" + NumberFormat.getCurrencyInstance().format(monthlyMortgage));

        scanner.close();

    }

    private static void readingInput(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Age? " );
        var age = scanner.nextDouble();
        System.out.println("You are : " + age);
        scanner.nextLine();

        System.out.print("Name? " );
        var name = scanner.nextLine();
        System.out.println("Your name is : " + name);
        scanner.nextLine();

        System.out.print("Location? " );
        var Location = scanner.nextLine();
        System.out.println("Your Location is : " + Location);
        scanner.nextLine();

        scanner.close();
    }

    private static void constants(){
        final float PI = 3.141593F;
        p("Final PI: ", PI);

        String x = "1";
        String y = "Hello";
        System.out.println(Integer.parseInt(x));
        System.out.println(Integer.parseInt(y));
    }
    private static void matrix()
    {
        int[][] matrixNumbers = new int[2][4];
        int[][] matrixNumbersInit = {{0,1,2,3},{10,11,12,13}};
        matrixNumbers[0][0] = 0;
        matrixNumbers[0][1] = 1;
        matrixNumbers[0][2] = 2;
        matrixNumbers[0][3] = 3;
        matrixNumbers[1][0] = 10;
        matrixNumbers[1][1] = 11;
        matrixNumbers[1][2] = 12;
        matrixNumbers[1][3] = 13;
        System.out.println(Arrays.deepToString(matrixNumbers));
        System.out.println(Arrays.deepToString(matrixNumbersInit));
    }
    private static void arraysAndBeyond()
    {
        int[] numbers = new int[5];
        int[] ages = numbers;
        numbers[2] = 10000;
        int[] digits = {1,10,6,25,1,88,8,18,2,5,4,1,2,3,5,8,13};

        p("Digits Before Sorting: ", Arrays.toString(digits));
        p("Digits: ", digits.length);
        Arrays.sort(digits);
        p("Digits After Soring: ", Arrays.toString(digits));

        p("Numbers: ", Arrays.toString(numbers));
        p("Ages: ", Arrays.toString(ages));
    }
    private static void dataTypes()
    {
        byte byteNumber = 1; // +/- 127
        short sortNumber = 1; // +/- 32K
        int integerNumber = 2_140_000_000;// +/- 2B
        long longNumber = 9_222_999_999_999_999_999L;// +/-
        // For decimals
        float floatNumber = 1F;//
        double doubleNumber = 1D;
        char character = 'a';
        boolean booleanValue = true;
        p("Short Number", sortNumber);
        p("Integer Number", integerNumber);
        p("Long Number", longNumber);
        p("Float Number", floatNumber);
        p("Double Number", doubleNumber);

        Date now = new Date();
        p("Now: ", now.getTime());

        Point pointA = new Point(100,200);
        p("Point A (Before)", pointA);
        Point pointB = pointA;
        pointB.x = 9876;
        pointB.y = -5432;
        p("Point A (After)", pointA);

        // BEWARE OF REFERENCE TYPE ASSIGNMENTS!!!!!


        String message = new String("Hello World!");
        String subject = "Message";
        // = is the same as new String (for the String)
        p("Stars With", subject.startsWith("MesX"));
        p("Index of", subject.indexOf("MesX"));
        p("Index of", subject.indexOf("ss"));
        p("Replace", subject.replace ("ss","_NEW_"));
        p("To lowercase", subject.toLowerCase ());
        p("To uppercase", subject.toUpperCase ());
        p("Compare", subject.compareTo(subject.toUpperCase()));
        p("Equals", subject.equalsIgnoreCase(subject.toUpperCase()));
        p("Escaping Charcters", "Backlash: \\");

    }

        private static void p(String message, Object toPrint)
        {
            System.out.println(message + ": " + toPrint);

        }
}
