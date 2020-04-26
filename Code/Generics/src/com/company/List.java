package com.company;

import java.lang.reflect.Type;

class item {
    private Object value;
    private Type type;
    public item(Object o, Type p)
    {
        value = o;
        type = p;
        System.out.println(o);
        System.out.println(p);
    }
}
public class List {

    private item[] list = new item[10];
    private int count = 0;
    public void add(Object o)
    {
        list[count++] = new item(o, o.getClass());
    }
}
