package j100xx;

import java.io.*;
import java.util.*;

class Complex{
    double real;
    double image;
    public Complex(double real,double image) {
        this.real = real;
        this.image = image;
    }
    public Complex(Complex c) {
        this.real = c.real;
        this.image = c.image;
    }
    public double getReal() {
        return real;
    }
    public double getImage() {
        return image;
    }
    public void setReal(double real) {
        this.real = real;
    }
    public void setImage(double image) {
        this.image = image;
    }
    public String toString() {
        return "(" + String.format("%.5f", real) + ")" + "+" + "(" + String.format("%.5f", image) + ")" + "i";
    }
    public Complex add(Complex c) {
        return new Complex( this.real + c.real, this.image + c.image );
    }
    public Complex sub(Complex c) {
        return new Complex( this.real - c.real, this.image - c.image );
    }
    public Complex multiply(Complex c) {
        return new Complex(
                this.real * c.real - this.image * c.image,
                this.real * c.image + this.image * c.real);
    }
    public Complex exp() {
        return new Complex(Math.exp(this.real) * Math.cos(this.image),
                Math.exp(this.real) * Math.sin(this.image) );
    }
    public double abs() {
        return Math.sqrt( this.real * this.real + this.image * this.image );
    }
}

public class j10032
{
    public static void main(String[] args) {

        /*构造函数参数按顺序为:实部,虚部*/
        Complex c1 = new Complex(5.0, 6.8);
        Complex c2 = new Complex(c1);

        double value = c1.getReal();
        System.out.println(String.format("%.5f", value));     //输出为:实部

        value = c1.getImage();
        System.out.println(String.format("%.5f", value));     //输出为:虚部

        value = c1.abs();                                     // c1.abs()： 复数c1的模
        System.out.println(String.format("%.5f", value));

        Complex texp = c1.exp();  // e为底数，复数c1为指数
        System.out.println(texp.toString());   //toString格式为:(5.58000)+(7.74000)i

        c2.setReal(9.6);    //修改实部
        c2.setImage(8.2);	//修改虚部

        Complex tem = c1.add(c2);  // tem = c1 + c2 ，注意c1, c2都不会改变，返回新建对象tem
        System.out.println(tem.toString());

        tem = c1.sub(c2);          // tem = c1 - c2 ，注意c1, c2都不会改变，返回新建对象tem
        System.out.println(tem.toString());

        tem = c1.multiply(c2);     // tem = c1 * c2 ，注意c1, c2都不会改变，返回新建对象tem
        System.out.println(tem.toString());
    }
}