package j100xx;

import java.util.HashMap;

import java.util.Scanner;

public class j10030 {
    public static void main(String[] args) {
        HashMap<String,String> code = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        // 输入信息存入哈希表
        int N = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < N; i++)
        {
            String tempStr = sc.nextLine();
            String[] tempStrArr = tempStr.split(" ");
            code.put(tempStrArr[0], tempStrArr[1]);
        }
        
        // 输出信息查询
        int IN = Integer.parseInt(sc.nextLine());
        String[] cityKey = new String[IN];
        for(int i = 0; i < IN; i++)
        {
            String tempStr = sc.nextLine();
            cityKey[i] = tempStr;
        }

        // 输出信息
        for(int i = 0;i < IN;i++)
        {
            System.out.println(cityKey[i] + " " + code.get(cityKey[i]));
        }
    }

}