package j100xx;

import java.util.Scanner;

public class j10018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = -1;
        N = sc.nextInt();
        System.out.print(N+"=");
        for(int i=2;i<N+1;i++) {
            while(N%i==0&&N!=i) {
                N/=i;
                System.out.print(i+"*");
            }
            if(N==i) {
                System.out.println(i);
                break;
            }
        }
    }
}