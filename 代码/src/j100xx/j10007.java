package j100xx;

import java.util.Scanner;

public class j10007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = -1;
        N = sc.nextInt();
        Double[] a = new Double[N];
        for(int i=0;i<N;i++)
        {
            a[i]=sc.nextDouble();
        }
        double minv = a[0],maxv=a[0];
        for(int i=0;i<a.length;i++)
        {
            if(a[i]<minv)
                minv=a[i];
            if(a[i]>maxv)
                maxv=a[i];
        }
        System.out.printf("minv:"+"%.5f",minv);
        System.out.println();
        System.out.printf("maxv:"+"%.5f",maxv);

    }

}