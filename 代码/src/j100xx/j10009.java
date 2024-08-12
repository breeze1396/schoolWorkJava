package j100xx;/* 输入一行字符串，然后将每个单词的首字母变为大写。	*/

import java.util.Scanner;

public class j10009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        String[] a = str.split(" ");
        for(int i = 0; i < a.length; ++i)
        {
            a[i] = Character.toUpperCase(a[i].charAt(0)) + a[i].substring(1);
        }
        System.out.println(String.join(" ",a));
    }
}