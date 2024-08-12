package j100xx;/* 	从键盘输入一行字符串，请在单词间做逆序调整。举例：“cat loves dog”逆序成“dog loves cat”。 */

import java.util.Scanner;

public class j10010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        str = sc.nextLine().trim();
        reserveWords(str);
    }
    public static void reserveWords(String s) {
        String[] a = s.split(" ");
        for(int i=a.length-1; i>=0; i--){
            System.out.print(a[i]+" ");
        }

    }

}