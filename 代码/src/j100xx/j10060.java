package j100xx;// 输入正整数N，然后输入N*N个正整数按一行一行的顺序排列成N行N列的矩阵，要求对矩阵按逆时针旋转90度，并输出结果。
/*
4
00 01 02 03
10 11 12 13
20 21 22 23
30 31 32 33
*/
import java.util.Scanner;
public class j10060 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[][] rotatedMatrix = new int[N][N];
        for(int times = 0; times<3; ++times) {
            rotatedMatrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    rotatedMatrix[j][i] = matrix[N - 1 - i][j];
                }
            }
            matrix =rotatedMatrix;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(rotatedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}