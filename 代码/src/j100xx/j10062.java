package j100xx;

import java.util.Scanner;
// ok
public class j10062 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        String str = sc.nextLine();
        for(int i = 0;i < str.length();i++)
        {
            if(count < 0)
                break;
            String temp = str.substring(i,i + 1);
            if(temp.equals("("))
                count ++;
            if(temp.equals(")"))
                count --;
        }
        if(count == 0)
            System.out.println(1);
        else
            System.out.println(0);
    }

}