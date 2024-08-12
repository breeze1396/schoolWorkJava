package j100xx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class j10045 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Double[] Arr = new Double[N];

        for(int i = 0; i < N; i++)
        {
            Arr[i] = sc.nextDouble();
        }
        Arrays.sort(Arr);
        System.out.printf("%.5f",Arr[N-K]);
    }

}