package j100xx;

import java.util.Scanner;

public class j10026 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        if(K < 2 || K > 16)
            return;
        String s = Integer.toString(N,K);
        System.out.println(s.toUpperCase());
    }

}