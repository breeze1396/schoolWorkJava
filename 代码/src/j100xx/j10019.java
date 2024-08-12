package j100xx;

import java.util.Scanner;
public class j10019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrefectNum(sc.nextInt());
    }
    public static void PrefectNum(int a) {
        for(int i=1; i<a; i++) {
            int sum = 0;
            for(int j=1; j<=i/2; j++) {
                if(i % j == 0)
                    sum+=j;
            }
            if(sum == i)
                System.out.print(i+" ");
        }
    }
}