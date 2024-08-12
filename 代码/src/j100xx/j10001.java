package j100xx;

import java.util.Scanner;

public class j10001 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String b=sc.nextLine();
        int zm=0,kg=0,qt=0;
        for(int i=0;i<b.length();i++)
        {
            if(b.charAt(i)>=65&&b.charAt(i)<=90)
                zm++;
            else if(b.charAt(i)>=97&&b.charAt(i)<=122)
                zm++;
            else if(b.charAt(i)==32)
                kg++;
            else
                qt++;
        }
        System.out.println("字母:"+zm);
        System.out.println("空格:"+kg);
        System.out.println("其他:"+qt);
    }

}