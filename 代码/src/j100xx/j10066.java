package j100xx;/*
19
00:   mov a     ,  0
  01 :        mov i  , a
02:      cmp i  ,  5
   03: jg 7
04:  add a  , i
   05  :  add i    , 1
06  :  jmp     2
  07:printi     a
  08:   printi   i
  09 : sub a    2
  10: mul  i  3
  11: div   i 3
  12:  printi   100
    13:    jmp 14
  14   :   printi   i
  15:     cmp i  ,  a
  16:  mul a, i
17: sub a,i
18:   div  a,    i


输出
15
6
* */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SimpleVirtualMachine {
    private static String[] cmds;
    private static final int[] variables = new int[26]; // 用于存储a-z的变量值

    private static int flag;
    public SimpleVirtualMachine() {

        read();

        int line = 0;
        while (true)
        {
            int t = executeOneInstruction(line);
            line++;
            if(t > 0) {
                line = t;
            }
            if(line >= cmds.length) return;
        }
    }
    private static void read()
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        cmds = new String[N];
        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            cmds[i] =  scanner.nextLine().trim().replaceAll("\\s+", " ").replace(", ", ",");
        }
    }

    // 如果返回非负数N，则下一次命令行号：N
    public int executeOneInstruction(int i) {
        String instruction = cmds[i];
        //Scanner sc = new Scanner(System.in);
        //String instruction = sc.nextLine();

        // 行号 命令 参数1，参数2
        List<String> parts = getPart(instruction);
        String op = parts.get(0);
        String v1 = parts.get(1);
        String v2 = parts.size() > 2 ? parts.get(2) : "";

        //System.out.println(op+"\n"+v1+"\n"+v2);

        // 双
        if(!v2.isEmpty())
        {
            binnaryOp(op, v1, v2);
        }
        else
        {
            return singleOp(op, v1);
        }
        return -1;
    }

    private static void binnaryOp(String op, String v1, String v2)
    {
        boolean isa_z = 'a' <= v2.charAt(0) && v2.charAt(0) <= 'z';
        switch (op) {
            case "mov":
                // 后面为变量
                if (isa_z) {
                    variables[v1.charAt(0) - 'a'] = variables[v2.charAt(0) - 'a'];
                } else
                {
                    variables[v1.charAt(0) - 'a'] = Integer.parseInt(v2);
                }
                break;
            case "add":
                // 后面为变量
                if (isa_z) {
                    variables[v1.charAt(0) - 'a'] += variables[v2.charAt(0) - 'a'];
                } else {
                    variables[v1.charAt(0) - 'a'] += Integer.parseInt(v2);
                }
                break;
            case "sub":
                // 后面为变量
                if (isa_z) {
                    variables[v1.charAt(0) - 'a'] -= variables[v2.charAt(0) - 'a'];
                } else {
                    variables[v1.charAt(0) - 'a'] -= Integer.parseInt(v2);
                }
                break;
            case "mul":
                // 后面为变量
                if (isa_z) {
                    variables[v1.charAt(0) - 'a'] *= variables[v2.charAt(0) - 'a'];
                } else {
                    variables[v1.charAt(0) - 'a'] *= Integer.parseInt(v2);
                }
                break;
            case "div":
                // 后面为变量
                if (isa_z) {
                    variables[v1.charAt(0) - 'a'] /= variables[v2.charAt(0) - 'a'];
                } else {
                    variables[v1.charAt(0) - 'a'] /= Integer.parseInt(v2);
                }
                break;
            case "cmp":
                if (isa_z) {
                    flag = variables[v1.charAt(0) - 'a'] - variables[v2.charAt(0) - 'a'];
                } else {
                    flag = variables[v1.charAt(0) - 'a'] - Integer.parseInt(v2);
                }
                break;
        }
    }
    private static int singleOp(String op, String v1)
    {
        boolean isa_z = 'a' <= v1.charAt(0) && v1.charAt(0) <= 'z';
        switch (op) {
            case "jg":
                if (flag > 0) {
                    if (isa_z)
                        return variables[v1.charAt(0) - 'a'];
                    return Integer.parseInt(v1);
                }
                break;
            case "jl":
                if (flag < 0) {
                    if (isa_z)
                        return variables[v1.charAt(0) - 'a'];
                    return Integer.parseInt(v1);
                }
                break;
            case "je":
                if (flag == 0) {
                    if (isa_z)
                        return variables[v1.charAt(0) - 'a'];
                    return Integer.parseInt(v1);
                }
                break;
            case "jne":
                if (flag != 0) {
                    if (isa_z)
                        return variables[v1.charAt(0) - 'a'];
                    return Integer.parseInt(v1);
                }
                break;
            case "jmp":
                if (isa_z)
                    return variables[v1.charAt(0) - 'a'];
                return Integer.parseInt(v1);
            case "printi":
                if (isa_z)
                    System.out.println(variables[v1.charAt(0) - 'a']);
                else
                    System.out.println(Integer.parseInt(v1));
                break;
        }
        return -1;
    }
    List<String> getPart(String strCmdLine)
    {
        List<String> ans = new ArrayList<>();
        int i = strCmdLine.indexOf(":")+1;

        // 跳过空格
        while (i < strCmdLine.length() && strCmdLine.charAt(i) == ' ')
        {
            ++i;
        }

        String temp = "";
        // 获取操作符
        while (i < strCmdLine.length() && strCmdLine.charAt(i) != ' ')
        {
            temp += strCmdLine.charAt(i);
            ++i;
        }
        ans.add(temp); temp = "";

        // 跳过空格
        while (i < strCmdLine.length() && strCmdLine.charAt(i) == ' ')
        {
            ++i;
        }

        // 获取第一个变量
        while (i < strCmdLine.length() && strCmdLine.charAt(i) != ' ' && strCmdLine.charAt(i) != ',')
        {
            temp += strCmdLine.charAt(i);
            ++i;
        }
        ans.add(temp); temp = "";

        // 跳过逗号
        // 跳过空格
        while (i < strCmdLine.length() && (strCmdLine.charAt(i) == ' ' || strCmdLine.charAt(i) == ','))
        {
            ++i;
        }

        // 获取第二个变量
        while (i < strCmdLine.length())
        {
            temp += strCmdLine.charAt(i);
            ++i;
        }
        ans.add(temp);

        return ans;
    }
}


public class j10066 {
    public static void main(String[] args) {
        SimpleVirtualMachine svm = new SimpleVirtualMachine();
    }
}