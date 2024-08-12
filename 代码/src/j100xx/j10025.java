package j100xx;

import java.util.Scanner;

public class j10025 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        char[] a = sentence.toCharArray();
        for(int i = 0; i < a.length; i++)
        {
            if(a[i] >= 97 && a[i] <= 99)
                a[i] = '2';
            else if(a[i] >= 100 && a[i] <= 102)
                a[i] = '3';
            else if(a[i] >= 103 && a[i] <= 105)
                a[i] = '4';
            else if(a[i] >= 106 && a[i] <= 108)
                a[i] = '5';
            else if(a[i] >= 109 && a[i] <= 111)
                a[i] = '6';
            else if(a[i] >= 112 && a[i] <= 115)
                a[i] = '7';
            else if(a[i] >= 116 && a[i] <= 118)
                a[i] = '8';
            else if(a[i] >= 119 && a[i] <= 122)
                a[i] = '9';
            else if(a[i] == 32)
                a[i] = '0';
            System.out.print(a[i]);
        }
    }

}