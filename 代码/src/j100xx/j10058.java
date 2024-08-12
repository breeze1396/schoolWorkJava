package j100xx;// 输入正整数N，然后输入N*N个正整数按一行一行的顺序排列成N行N列的矩阵，要求对矩阵以从右上角到左下角的对角线为对称轴交换对称位置的元素，并输出结果。
import java.util.Scanner;
/*
4
00 01 02 03
10 11 12 13
20 21 22 23
30 31 32 33


33 01 02 03
10 11 12 13
20 21 22 23
30 31 32 00
*/
public class j10058 {
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
            for (int j = 0; j < N - i; j++) {
                int temp = matrix[i][j];
                int dis = N-i -j-1;
                matrix[i][j] = matrix[i+dis][j+dis];
                matrix[i+dis][j+dis] = temp;
            }
        }

        // 输出交换后的矩阵
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}