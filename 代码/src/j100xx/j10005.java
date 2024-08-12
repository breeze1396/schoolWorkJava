package j100xx;

import java.util.Scanner;

public class j10005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int[][] a = new int[K][K];
        int[][] b = new int[K][K];
        int z=1;
        for(int i=0;i<K;i++)
        {
            for(int j=0;j<K;j++)
            {
                a[i][j]=z;
                z++;
            }
        }
        for(int i=0;i<K;i++)
        {
            for(int j=0;j<K;j++)
            {
                b[j][i]=a[i][j];
            }
        }
        for(int i=0;i<K;i++)
        {
            for(int j=0;j<K;j++)
            {
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
    }
}