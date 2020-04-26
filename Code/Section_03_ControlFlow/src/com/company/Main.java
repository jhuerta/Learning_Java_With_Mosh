package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        fizzBuzz();
        loops();
    }

    private static void loops(){
        String[] fruits = {"mango", "orange","banana"};
        for (var fruit: fruits             ) {
            System.out.println(fruit);

        }


    }
    private static void fizzBuzz()
    {

        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();

        var fizz = ((number % 5) == 0) ? "Fizz" : "";
        var buzz = ((number % 3)==0) ? "Buzz" : "";
        var condition = !(fizz + buzz).equals("");
        var output = condition ? fizz + buzz : Integer.toString(number);

        System.out.println("Output: " + output);


    }
}
