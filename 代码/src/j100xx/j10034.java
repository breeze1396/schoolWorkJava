package j100xx;

import java.io.*;
import java.util.*;

class Circle
{
    private final double Pi = 3.1415926;
    private double X;
    private double Y;
    private double R;
    Circle(double x, double y, double r)
    {
        X = x;
        Y = y;
        R = r;
    }
    Circle(Circle other)
    {
        X = other.X;
        Y = other.Y;
        R = other.R;
    }
    public void setX(double a){ X = a; }
    public void setY(double a){ Y =a; }
    public void setR(double a){ R = a;}
    public double getX(){return X;}
    public double getY(){return Y;}
    public double getR(){return R;}

    /* 比较面积，如果rc2面积更大则输出1, 相等输出0，否则输出-1; */
    public int CompareCS(Circle circle){
        if(R > circle.R) return 1;
        else if(R==circle.R) return 0;
        return -1;
    }
    public int CompareCL(Circle other)
    {
        return CompareCS(other);
    }
    public String toString()
    {
        return String.format("x:%.5f\ny:%.5f\nr:%.5f\n面积:%.5f\n周长:%.5f",
                X,Y,R,Pi*R*R,2*Pi*R);
    }
}

public class j10034 {
    public static void main(String[] args) {
        /* 构造函数参数按顺序为:x, y, r */
        Circle rc1 = new Circle(10.01, 20.0, 30.0);
        Circle rc2 = new Circle(rc1);

        System.out.println(rc1.getX());
        System.out.println(rc1.getY());
        System.out.println(rc1.getR());

        rc2.setX(40.66);
        rc2.setY(58.18);
        rc2.setR(28.98);

        /* 比较周长，如果rc2周长更长则输出1, 相等输出0，否则输出-1; */
        System.out.println(rc2.CompareCL(rc1));
        System.out.println(rc2);
    }
}
