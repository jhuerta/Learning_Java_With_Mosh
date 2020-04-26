package com.company.Point;

import java.io.IOException;
import java.util.Objects;

public class Point {
    public double x;
    public double y;



    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public boolean exMethod(Object obj)  throws IOException{
        System.out.println("called equqls");
        var pointToCompare = (Point) obj;
        if(obj == null)
        {
            throw new IOException();

        }
        return x == pointToCompare.x && y ==pointToCompare.y;
    }

    @Override
    public boolean equals(Object obj) throws ExceptionInInitializerError{
        System.out.println("called equqls");
        var pointToCompare = (Point) obj;
        if(obj == null)
        {
            throw new ExceptionInInitializerError();

        }
        return x == pointToCompare.x && y ==pointToCompare.y;
    }

    @Override
    public int hashCode() {
        System.out.println("called hashcode");
        return Objects.hash(x,y);
    }
}
