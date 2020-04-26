package com.utils;

public class TextBox {
    public String getReverseText() {
        return reverseText;
    }

    public static String test()
    {
        return new TextBox().method(true);
    }

    private String text;
    public String reverseText;


    public void method(int a)
    {

    }

    public void method(int a, int b)
    {

    }

    public void method()
    {

    }

    public String method(boolean isitTrue)
    {
        return "nop";

    }

    public String method(String a)
    {

        return "hola";

    }

    public void setText(String newText)
    { String ip = getNewText(newText);
        this.reverseText = newText.toUpperCase();
        text = newText;
    }

    private String getNewText(String newText) {
        return findNewText(newText);
    }

    private String findNewText(String newText) {

        String hol = "hol";
        String hol1 = hol;
        return hol1;
    }

    public void clear()
    {
        this.setText("");
    }

    public void printMessage()
    {
        System.out.println(getText());
    }

    public String getText() {
        return text;
    }
}
