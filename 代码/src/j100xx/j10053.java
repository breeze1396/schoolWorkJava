package j100xx;/*输入正整数N和C，然后一行一行地输入N行浮点数组成的矩阵A，
再一行一行地输入N行浮点数组成的矩阵B，
其中每一行包含C个浮点数，要求计算并输出A+B。
 */

import java.util.Scanner;
/*
3
4
11.59 12.00 15.48 16.41
13.87 19.32 20.76 11.76
17.35 19.06 20.80 22.93
12.48 23.79 16.80 18.52
16.43 20.40 21.07 21.56
14.37 11.64 18.99 18.05
* */
public class j10053 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int C = scanner.nextInt();

        double[][] matrixA = new double[N][C];
        double[][] matrixB = new double[N][C];
        double[][] resultMatrix = new double[N][C];

        // 输入矩阵A
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < C; j++) {
                matrixA[i][j] = scanner.nextDouble();
            }
        }

        // 输入矩阵B
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < C; j++) {
                matrixB[i][j] = scanner.nextDouble();
            }
        }

        // 计算矩阵A和B的和
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < C; j++) {
                resultMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
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