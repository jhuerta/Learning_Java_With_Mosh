package com.company;

import com.utils.TextBox;

public class Main {

    public static void main(String[] args) {

        var textBox = new TextBox();

        System.out.println(TextBox.test());
        textBox.setText("Juan");
        textBox.printMessage();

    }


}
