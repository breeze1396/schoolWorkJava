package j100xx;

import java.util.Scanner;

public class j10003 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=-1;
        N=sc.nextInt();
        for(int i=2;i<=N;i++)
        {
            int j;
            for(j=2;j<=Math.sqrt(i);j++)
            {
                if(i%j==0)break;
            }
            if(j>Math.sqrt(i))
                System.out.print(i+" ");
        }
    }

}