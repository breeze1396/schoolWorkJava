package j100xx;/*输入正整数N，然后输入N个[0, 1]之间浮点数组成的向量M，
再输入N个浮点数组成的向量A，并输入N个浮点数组成的向量B。
现需要根据向量M的每一位置元素值生成向量R，
规则为：依次判M的每一个位置的元素值，
如果M的一个位置的元素值小于0.5，
则向量R对应位置元素值等于向量A的对应位置元素值，
否则向量R对应位置元素值等于向量B的对应位置元素值。
要求输出生成的向量R。
* */
/*
5
0.28 0.34 0.37 0.90 0.39
28.53 11.57 19.50 14.18 18.14
28.90 11.06 28.02 14.35 15.27
* */ //ok

import java.util.Scanner;
public class j10052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Double[] M = new Double[N];
        Double[] A = new Double[N];
        Double[] B = new Double[N];
        Double[] R = new Double[N];
        for(int i = 0;i < N;i++) {
            M[i] = sc.nextDouble();
        }
        for(int i = 0;i < N;i++) {
            A[i] = sc.nextDouble();
        }
        for(int i = 0;i < N;i++) {
            B[i] = sc.nextDouble();
        }
        for(int i = 0;i < N;i++) {
            if(M[i] < 0.5) {
                R[i] = A[i];
            } else {
                R[i] = B[i];
            }
        }
        for(int i = 0;i < N;i++) {
            System.out.format("%.5f" + " ", R[i]);
        }
    }

}