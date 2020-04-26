package com.company.UIControl;


public class UIControl {
    private boolean  isEnabled = true;

    public UIControl(boolean initialState)
    {
        System.out.println("I'm the UI Control");
        isEnabled = initialState;
    }

    public void disable(){
        isEnabled = false;
    }

    public void enable(){
        isEnabled = true;
    }

    public boolean isEnabled(){
        return isEnabled;
    }
}
