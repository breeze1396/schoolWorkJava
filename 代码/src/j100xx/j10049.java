package j100xx;/*
输入正整数N和K，然后输入一个由N个浮点数组成的向量A，
再输入K个同样维度的向量，要求在K个向量中找出与向量A的欧氏距离最小的向量，
并输出找到的向量与向量A的欧氏距离。
*/
/*
5
3
22.07 12.22 15.58 26.47 15.52
14.34 28.91 28.48 12.45 12.39
19.68 25.84 16.65 21.69 26.72
15.22 14.56 23.48 14.57 18.50
*/// correct
import java.util.Scanner;
public class j10049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Double[] A = new Double[N];

        for(int i = 0;i < A.length;i++)
        {
            A[i] = sc.nextDouble();
        }
        Double[][] B = new Double[K][N];
        for(int i = 0;i < B.length;i++)
        {
            for(int j = 0;j < B[i].length;j++)
            {
                B[i][j] = sc.nextDouble();
            }
        }
        //求欧氏距离

        Double[] V = new Double[K];
        for(int i = 0;i < K;i++)
        {
            double value = 0;
            for(int j = 0;j < N;j++)
            {
                value += Math.pow(A[j] - B[i][j],2);
            }
            V[i] = Math.sqrt(value);
        }
        //寻找与向量A的欧氏距离最小的向量
        double minValue = V[0];
        for(int i = 1 ;i < V.length;i++)
        {
            if(V[i] < minValue)
                minValue = V[i];
        }
        System.out.printf("%.5f",minValue);
    }
}