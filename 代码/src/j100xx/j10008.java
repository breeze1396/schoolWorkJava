package j100xx;/*	输入正整数N，然后输入N个浮点数，再按从小到大排序并输出排序结果 */

import java.util.Arrays;
import java.util.Scanner;

public class j10008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = -1;
        N = sc.nextInt();
        double[] a = new double[N];
        for(int i=0;i<a.length;i++)
        {
            a[i] = sc.nextDouble();
        }

        Arrays.sort(a);

        for (double v : a) {
            System.out.printf("%.5f\n", v);
        }
    }
}