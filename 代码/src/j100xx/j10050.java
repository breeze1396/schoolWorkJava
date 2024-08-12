package j100xx;

import java.util.Scanner;
/*
5
6
26.26 29.84 22.67 21.63 22.00
19.18 18.52 23.38 19.05 15.73
26.59 20.26 20.31 16.59 10.31
18.69 16.48 14.51 11.42 17.19
10.02 14.35 27.64 20.02 29.07
16.20 20.23 28.91 11.52 17.56
*/// correct
public class j10050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        double sum, minSum = Double.MAX_VALUE;
        double[][] data= new double[K][N];
        for(int i = 0;i < K;i++) {
            for(int j = 0 ;j < N;j++) {
                data[i][j] = sc.nextDouble();
            }
        }
        for(int i = 0 ;i < K;i++) {
            for(int j = i + 1;j < K;j++) {
                sum = 0.0;
                for(int m = 0;m < N;m++) {
                    sum = sum + Math.pow(data[i][m] - data[j][m],2);
                }
                sum = Math.sqrt(sum);
                if(sum < minSum) {
                    minSum = sum;
                }
            }
        }
        System.out.format("%.5f",minSum);
    }
}