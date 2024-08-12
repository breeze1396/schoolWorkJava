package j100xx;

import java.text.DecimalFormat;
import java.util.Scanner;

public class j10002 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        double sum=0;
        for(double i=0;i<=k;i++)
        {
            sum=sum+((i+6)/(i+10));
        }
        System.out.print("sum:");
        System.out.printf("%.5f",sum);
    }
}