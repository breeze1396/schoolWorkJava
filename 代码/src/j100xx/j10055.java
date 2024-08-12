package j100xx;

import java.util.Scanner;
/* ok
3
4 4
2
2.22 5.48 2.55 2.73
2.89 1.05 4.42 2.01
4.21 2.32 1.49 4.07
2.65 2.35
3.58 1.09
1.51 5.95
4.38 5.30
* */
public class j10055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N1 = sc.nextInt();
        int C1 = sc.nextInt();
        int N2 = sc.nextInt();
        int C2 = sc.nextInt();
        Double[][] A = new Double[N1][C1];
        Double[][] B = new Double[N2][C2];
        for(int i = 0;i < N1;i++)
        {
            for(int j = 0;j < C1;j++)
            {
                A[i][j] = sc.nextDouble();
            }
        }
        for(int i = 0;i < N2;i++)
        {
            for(int j = 0;j < C2;j++)
            {
                B[i][j] = sc.nextDouble();
            }
        }
        for(int i = 0;i < N1;i++)
        {
            for(int j = 0;j < C2;j++)
            {
                double sum = 0.0;
                for(int k = 0;k < C1;k++)
                {
                    sum = sum + A[i][k]*B[k][j];
                }
                System.out.format("%.5f" + " ", sum);
            }
            System.out.println();
        }
    }

}