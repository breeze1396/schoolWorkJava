package j100xx;/*指令分割。*/

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
9
0 :  jne  2585
   1 :  je 3160
   2:   div   r,  a
 3 :  printi     e
4 : add   e,e
5: je          1762
6 : jmp  1032
7 : mov b, 3616
8: mov n  2429
* */
public class j10021 {
    public static void main(String[] args) {
        f2();
    }

    private static void f1()
    {
        Scanner sc = new Scanner(System.in);
        int N = -1;
        N = Integer.parseInt(sc.nextLine());
        String[] a = new String[N];
        for(int i=0;i<N;i++)
        {
            a[i] = sc.nextLine().replace(" ","");
        }
        sc.close();
        String[] singleArr = {"printi","jg","jl","je","jne","jmp"};
        String[] doubleArr = {"mov","add","sub","mul","div","cmp"};
        for(int i=0;i<N;i++) {
            int flag = 0;
            for(String tmp:singleArr)
            {
                if(a[i].indexOf(":"+tmp)>0)
                {
                    flag = 1;
                    String[] tmpStrArr = a[i].split(":"+tmp);
                    System.out.println("LineNo="+tmpStrArr[0]);
                    System.out.println("OP="+tmp);
                    System.out.println("N1="+tmpStrArr[1]);
                }
            }
            if(flag == 0){
                for(String tmp:doubleArr)
                {
                    if(a[i].indexOf(":"+tmp)>0) {
                        flag = 2;
                        String[] tmpStrArr = a[i].split(":"+tmp);
                        System.out.println("LineNo="+tmpStrArr[0]);
                        System.out.println("OP="+tmp);
                        System.out.println("N1="+tmpStrArr[1].split(",")[0]);
                        System.out.println("N2="+tmpStrArr[1].split(",")[1]);
                    }
                }
            }
            if(flag == 0)
                return;
        }
    }
    private static void f2()
    {
        Scanner sc = new Scanner(System.in);
        int N = -1;
        N = Integer.parseInt(sc.nextLine());
        String[] a = new String[N];
        for(int i=0; i<N; i++)
        {
            a[i] = sc.nextLine();
        }

        for(int i=0;i<N;i++)
        {
            f21(a[i]);
        }
    }

    private static void f21(String line)
    {
        Pattern pattern = Pattern.compile("\\s*(\\d+)\\s*:");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) { // 如果在当前行找到匹配项
            System.out.println("LineNo=" + matcher.group(1));
        }

        pattern = Pattern.compile(":\\s*([a-z]+)");
        matcher = pattern.matcher(line);
        if  (matcher.find()) {
            System.out.println("OP=" + matcher.group(1));
        }

        if(line.contains(","))
        {
            pattern = Pattern.compile("([a-z0-9]+)\\s*,");
        }
        else {
            pattern = Pattern.compile("([a-z0-9]+)\\s*$");
        }

        matcher = pattern.matcher(line);
        if  (matcher.find()) {
            System.out.println("N1=" + matcher.group(1));
        }

        pattern = Pattern.compile(",\\s*([a-z0-9]+)\\s*$");
        matcher = pattern.matcher(line);
        if  (matcher.find()) {
            System.out.println("N2=" + matcher.group(1));
        }
    }


}