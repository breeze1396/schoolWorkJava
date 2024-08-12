package j100xx;

import java.util.Scanner;

public class j10013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        double L = 0.0,H;
        for(int i=1;i<N;i++)
        {
            L=L+M/(Math.pow(2, i-1));
        }
        H=M/(Math.pow(2,N));
        System.out.printf("%.5f\n",L+M);
        System.out.printf("%.5f",H);
    }

}