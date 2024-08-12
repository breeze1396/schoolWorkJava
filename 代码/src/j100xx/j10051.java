package j100xx;/*输入正整数N和K，然后输入K个向量，
其中每个向量由N个浮点数组成，
然后计算出这K个向量的平均值保存在向量V，
要求在K个向量中找出与向量V的欧氏距离最小的向量，
并输出找到的向量与向量V的欧氏距离。
 */
/*
5
6
21.41 19.25 15.52 23.41 19.46
14.47 13.91 29.66 21.83 29.60
22.88 22.99 18.07 14.94 23.81
24.69 17.65 25.64 13.77 15.43
23.30 17.93 26.39 21.41 17.90
25.45 12.49 28.13 14.74 17.48
* */  // ok
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class j10051 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        List<double[]> arrayList = new ArrayList<>();
        double[] averageVector = new double[N];
        for (int k = 0; k < K; k++) {
            double[] vector = new double[N];
            for (int n = 0; n < N; n++) {
                vector[n] = scanner.nextDouble();
            }
            arrayList.add(vector);
            for (int n = 0; n < N; n++) {
                averageVector[n] += vector[n];
            }
        }

        for (int n = 0; n < N; n++) {
            averageVector[n] /= K;
        }

        double minDistance = Double.MAX_VALUE;
        for (double[] vector : arrayList) {
            double distance = calculateEuclideanDistance(vector, averageVector);
            if (distance < minDistance) {
                minDistance = distance;
            }
        }

        System.out.format("%.5f", minDistance);
    }

    private static double calculateEuclideanDistance(double[] vector1, double[] vector2) {
        double sum = 0;
        for (int i = 0; i < vector1.length; i++) {
            sum += Math.pow(vector1[i] - vector2[i], 2);
        }
        return Math.sqrt(sum);
    }
}