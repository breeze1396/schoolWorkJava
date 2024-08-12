package j100xx;/*输入正整数N和C，然后一行一行地输入N行浮点数组成的矩阵A，
再一行一行地输入N行浮点数组成的矩阵B，
其中每一行包含C个浮点数，要求计算并输出A+B。
 */

import java.util.Scanner;
/*
3
4
21.87 20.49 21.56 14.72
13.27 18.78 17.32 21.90
19.60 10.33 23.42 23.03
24.05 20.36 18.32 15.64
16.57 14.62 24.17 10.72
24.57 23.22 22.05 16.78
* */ // ok
public class j10054 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int C = scanner.nextInt();

        double[][] matrixA = new double[N][C];
        double[][] matrixB = new double[N][C];
        double[][] resultMatrix = new double[N][C];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < C; j++) {
                matrixA[i][j] = scanner.nextDouble();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < C; j++) {
                matrixB[i][j] = scanner.nextDouble();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < C; j++) {
                resultMatrix[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }

        for (double[] row : resultMatrix) {
            for (double value : row) {
                System.out.format("%.5f ",value);
            }
            System.out.println();
        }
    }

}