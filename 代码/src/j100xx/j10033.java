package j100xx;

import java.io.*;
import java.util.*;

class Rect {
    Double x;
    Double y;
    Double L;
    Double W;
    public Rect(Double x,Double y,Double l,Double w) {
        this.x = x;    this.y = y;
        this.L = l;    this.W = w;
    }
    public Rect(Rect r) {
        this.x = r.x;   this.y = r.y;
        this.L = r.L;   this.W = r.W;
    }
    public Double getX() {
        return this.x;
    }
    public void setX(Double x) {
        this.x = x;
    }
    public Double getY() {
        return this.y;
    }
    public void setY(Double y) {
        this.y = y;
    }
    public Double getL() {
        return this.L;
    }
    public void setL(Double l) {
        this.L = l;
    }
    public Double getW() {
        return this.W;
    }
    public void setW(Double w) {
        this.W = w;
    }
    public Double Area() {
        return L * W;
    }
    public int CompareArea(Rect r) {
        Double a = this.Area();
        Double b = r.Area();
        if(a > b)
            return 1;
        else if(a.equals(b))
            return 0;
        else
            return -1;
    }
    public String  toString() {
        return (String.format("x:%.5f",x) +"\n" + String.format("y:%.5f", y) + "\n" + String.format("L:%.5f", L)+ "\n" + String.format("W:%.5f", W) +"\n" + String.format("面积:%.5f", this.Area()));
    }
}

public class j10033
{
    public static void main(String[] args) {

        /* 构造函数参数按顺序为:x, y, L, W */
        Rect rc1 = new Rect(10.0, 20.0, 30.0, 40.0);
        Rect rc2 = new Rect(rc1);

        System.out.println(String.valueOf(rc1.getX()));
        System.out.println(String.valueOf(rc1.getY()));
        System.out.println(String.valueOf(rc1.getL()));
        System.out.println(String.valueOf(rc1.getW()));

        rc2.setX(50.0);
        rc2.setY(60.0);
        rc2.setL(70.02589);
        rc2.setW(80.01);

        /* 比较面积，如果rc2面积更大则输出1, 相等输出0，否则输出-1; */
        System.out.println(String.valueOf(rc2.CompareArea(rc1)));
        System.out.println(String.valueOf(rc2.toString()));


    }
}