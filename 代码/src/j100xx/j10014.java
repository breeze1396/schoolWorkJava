package j100xx;

import java.util.Scanner;
public class j10014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = -1;
        N = sc.nextInt();
        F(N);
    }
    public static void F(int a) {
        int[] b = new int[a];
        for(int i=0;i<a;i++)
        {
            b[i]=i+1;
        }
        int currentNum = 1;
        int count = b.length;
        for(int i=0;;i++)
        {
            if(count==1) {
                break;
            }
            if(i>=b.length) {
                i=0;
            }
            if(b[i]==0) {
                continue;
            }
            if(currentNum % 5 == 0) {
                count--;
                b[i]=0;
            }
            if(currentNum == 5) {
                currentNum = 1;
            }
            else {
                currentNum++;
            }
        }
        for (int j : b) {
            if (j != 0) {
                System.out.println(j);
            }
        }
    }

}