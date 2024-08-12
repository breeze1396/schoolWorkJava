package j100xx;//输入正整数N，然后输入N*N个正整数按一行一行的顺序排列成N行N列的矩阵，要求对矩阵按水平方向翻转，并输出结果。
import java.util.Scanner;

public class j10057 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][N - 1 - j];
                matrix[i][N - 1 - j] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}