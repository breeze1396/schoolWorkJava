package j100xx;/*
输入正整数N和C，然后一行一行地输入N行[0, 1]之间的浮点数组成的矩阵M，
再一行一行地输入N行浮点数组成的矩阵A，再一行一行地输入N行浮点数组成的矩阵B，
其中所有矩阵的每一行都包含C个浮点数。现需要根据矩阵M的每一位置元素值生成矩阵R，
规则为：依次判M的每一个位置的元素值，如果M的一个位置的元素值小于0.5，
则矩阵R对应位置元素值等于矩阵A的对应位置元素值，
否则矩阵R对应位置元素值等于矩阵B的...

* */

/*ok
3
4
0.63 0.96 0.50 0.90
0.13 0.44 0.89 0.62
0.96 0.67 0.84 0.01
16.27 18.39 24.94 14.41
20.17 23.90 15.72 24.07
22.89 20.16 10.08 21.20
11.65 10.48 23.48 20.48
23.25 18.32 14.72 12.52
15.57 15.75 23.78 20.47
* *///ok
import java.util.Scanner;
public class j10056 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = sc.nextInt();
        Double[][] M = new Double[N][C];
        Double[][] A = new Double[N][C];
        Double[][] B = new Double[N][C];
        Double[][] R = new Double[N][C];
        for(int i = 0;i < N;i++) {
            for(int j = 0;j < C;j++) {
                M[i][j] = sc.nextDouble();
            }
        }
        for(int i = 0;i < N;i++) {
            for(int j = 0;j < C;j++) {
                A[i][j] = sc.nextDouble();
            }
        }
        for(int i = 0;i < N;i++) {
            for(int j = 0;j < C;j++) {
                B[i][j] = sc.nextDouble();
            }
        }

        for(int i = 0;i < N;i++) {
            for(int j = 0;j < C;j++) {
                if(M[i][j] < 0.5) {
                    R[i][j] = A[i][j];
                } else {
                    R[i][j] = B[i][j];
                }
            }
        }
        for(int i = 0;i < N;i++) {
            for(int j = 0;j < C;j++) {
                System.out.format("%.5f" + " ", R[i][j]);
            }
            System.out.println();
        }
    }

}