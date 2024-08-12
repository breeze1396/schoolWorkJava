package j100xx;

import java.util.Scanner;

public class j10024 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] a = new int[N][N];

        for(int i = 0;i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for(int i = N - 1;i > -1;i--) {
            for (int j = 0; j < N; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    }

}