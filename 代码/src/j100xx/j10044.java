package j100xx;

import java.util.Scanner;

public class j10044 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        j10044 solution = new j10044();
        System.out.println(solution.longStr(str));
    }
    public String longStr(String s)
    {
        if(s.length() < 2)
            return s;
        int max_len = 1;
        int start = 0;
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0;i < s.length();i++)
        {
            dp[i][i] = 1;
        }
        char[] charArr = s.toCharArray();
        for(int l = 2;l <= s.length();l++)
        {
            for(int i = 0;i < s.length();i++)
            {
                int j = l + i - 1;
                if(j >= s.length())
                    break;
                if(charArr[i] != charArr[j]) {
                    dp[i][j] = 0;
                }
                else {
                    if(j - i < 3) {
                        dp[i][j] = 1;
                    }
                    else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if(dp[i][j] != 0 && j - i + 1 > max_len) {
                    max_len = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start,start + max_len);
    }
}