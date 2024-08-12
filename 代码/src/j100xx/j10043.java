package j100xx;

import java.io.*;

import java.util.Scanner;

public class j10043 {
    public static void main(String[] args) {
        boolean f = isF1();
        System.out.println(f?1:0);
    }

    static boolean isF1()
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder(str);
        return str.contentEquals(sb.reverse());
    }

}