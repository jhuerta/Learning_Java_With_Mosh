package com.company.TextBox;

import com.company.UIControl.UIControl;
import org.w3c.dom.Text;

public class TextBox extends UIControl
{
    public TextBox()
    {
        super(true);
        System.out.println("I'm text control - Eemptyy conostructor");
    }


    public TextBox(boolean initialState) {
        super(initialState);
        System.out.println("I'm text control");
    }
}
