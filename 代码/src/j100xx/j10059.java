package j100xx;// 输入正整数N，然后输入N*N个正整数按一行一行的顺序排列成N行N列的矩阵，要求对矩阵按顺时针旋转90度，并输出结果。
/*
3
1 4 7
2 5 8
3 6 9
*/
import java.util.Scanner;
public class j10059 {
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
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotatedMatrix[j][N - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(rotatedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}