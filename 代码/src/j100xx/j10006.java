package j100xx;

import java.util.Scanner;

public class j10006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = -1;
        N = sc.nextInt();
        double[] a = new double[N];
        for(int i=0;i<a.length;i++)
        {
            a[i]=sc.nextDouble();
        }
        double sum=0.0,mean,diff,c=0.0;
        for (double value : a) {
            sum = sum + value;
        }
        mean = sum / N;
        for (double v : a) {
            c = c + Math.pow((v - mean), 2);
        }
        diff=c/N;
        System.out.printf("mean:"+"%.5f",mean);
        System.out.println();
        System.out.printf("diff:"+"%.5f",diff);
    }

}