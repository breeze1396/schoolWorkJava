package j100xx;

import java.util.Scanner;

public class j10016 {
    public static void main(String[] args) {
        count();
    }

    public static void count()
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] ch = str.toCharArray();

        int[] temp = new int[26];
        for (char c : ch) {
            if (c >= 'a' && c <= 'z') {
                temp[c - 'a']++;
            }
        }
        for(int i=0;i<temp.length;i++)
        {
            System.out.println((char)(i+'a')+":"+temp[i]);
        }


        int blank = 0;
        for (char c : ch) {
            if (c == ' ')
                blank++;
        }
        System.out.println("空格:"+blank);
    }
}