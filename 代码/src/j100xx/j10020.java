package j100xx;

import java.util.Scanner;

public class j10020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder strBuilder = new StringBuilder();
        int count = 1;
        char c1=str.charAt(0);
        for(int i=1;i<str.length();i++)
        {
            char c2 = str.charAt(i);
            if(c1 == c2) {
                count++;
                continue;
            }
            if(count>1) {
                strBuilder.append(c1).append(count);
            }else {
                strBuilder.append(c1);
            }
            c1 = c2;
            count = 1;
        }
        if(count >1) {
            strBuilder.append(c1).append(count);
        }else {
            strBuilder.append(c1);
        }
        System.out.println(strBuilder);
    }
}