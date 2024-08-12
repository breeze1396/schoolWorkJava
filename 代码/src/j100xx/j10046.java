package j100xx;

import java.util.Scanner;
/*输入正整数N，然后输入N个浮点数组成的向量A，
再输入N个浮点数组成的向量B，要求计算并输出A+B。
 * */
public class j10046 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Double[] A = new Double[N];
        Double[] B = new Double[N];
        for(int i = 0; i < N;i++)
        {
            A[i] = sc.nextDouble();
        }
        for(int i = 0; i < N;i++)
        {
            B[i] = A[i] + sc.nextDouble();
        }
        for(int i = 0;i < N;i++)
        {
            System.out.printf("%.5f ", B[i]);
        }
    }

}