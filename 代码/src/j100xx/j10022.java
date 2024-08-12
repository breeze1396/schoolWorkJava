package j100xx;/*	二进制指令序列解码成字符串源代码*/

import java.util.*;
/*
5
mov f,h
add m,67890
jmp 25688
div k,b
je z
*/
class HexToCmd
{
    static Scanner sc = new Scanner(System.in);
    HashMap<Integer, String> m_mapHexToCmd;
    public HexToCmd()
    {
        m_mapHexToCmd = new HashMap<>();
        m_mapHexToCmd.put(0, "mov");
        m_mapHexToCmd.put(2, "add");
        m_mapHexToCmd.put(4, "sub");
        m_mapHexToCmd.put(6, "mul");
        m_mapHexToCmd.put(8, "div");
        m_mapHexToCmd.put(10, "cmp");
        m_mapHexToCmd.put(12, "je");
        m_mapHexToCmd.put(14, "jne");
        m_mapHexToCmd.put(16, "jl");
        m_mapHexToCmd.put(18, "jg");
        m_mapHexToCmd.put(20, "jmp");
        m_mapHexToCmd.put(22, "printi");
        String inStr = sc.nextLine();
        TransformoToCmd(inStr);
    }
    //传入需要是规范hex，加入函数进行判断
    public void TransformoToCmd(String strHex)
    {
        int i = 0;
        while (i < strHex.length())
        {
            String opCode = strHex.substring(i, i+2); i += 2; //获取操作符
            int intOpCode = Integer.parseInt(opCode, 16);
            Boolean isContainConst = (intOpCode % 2 == 1);
            Boolean isBinnary = (intOpCode < 12);
            if (isContainConst) intOpCode -= 1;

            String ans = m_mapHexToCmd.get(intOpCode);
            if (isBinnary)
            {
                //获取v1
                int v1 = Integer.parseInt(strHex.substring(i, i+2), 16) + 97; i += 2;
                if (isContainConst)
                {
                    //获取 常量v2
                    String v2str = strHex.substring(i, i+8);
                    int v2 = Integer.parseInt(v2str, 16); i += 8;
                    ans += " " + (char)v1 + ", " + v2;
                }
                else
                {
                    //获取 变量v2
                    int c2 = Integer.parseInt(strHex.substring(i, i+2), 16) + 97; i += 2;
                    //String v2 = Integer.toString(c2);
                    ans += " " + (char)v1 + ", " + (char)c2;
                }
            }
            else
            {  //如果是单元素
                if (isContainConst)
                {
                    //获取 常量v1
                    int v1 = Integer.parseInt(strHex.substring(i, i+8), 16); i += 8;
                    ans += " " + v1;
                }
                else
                {
                    //获取 变量v1
                    int v1 = Integer.parseInt(strHex.substring(i, i+2), 16) + 'a'; i += 2;
                    ans += " " + (char)v1;
                }
            }
            System.out.println(ans);
        }
    }
}

/*class CmdToHex
{
    HashMap<String, Integer> m_mapCmdToHex = new HashMap<>();
    private String ans;
    public void init()
    {
        m_mapCmdToHex.put("mov", 0);
        m_mapCmdToHex.put("add", 2);
        m_mapCmdToHex.put("sub", 4);
        m_mapCmdToHex.put("mul", 6);
        m_mapCmdToHex.put("div", 8);
        m_mapCmdToHex.put("cmp", 10);
        m_mapCmdToHex.put("je", 12);
        m_mapCmdToHex.put("jne", 14);
        m_mapCmdToHex.put("jl", 16);
        m_mapCmdToHex.put("jg", 18);
        m_mapCmdToHex.put("jmp", 20);
        m_mapCmdToHex.put("printi", 22);
        ans = "";
    }

    public CmdToHex()
    {
        init();
        Scanner sc = new Scanner(System.in);
        int line = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < line; ++i)
        {
            String strCmdLine = sc.nextLine();
            TransformoToHex(strCmdLine);
        }
        System.out.println(ans.trim());
    }
    public void TransformoToHex(String s)
    {
        List<String> parts = getPart(s);
        String op = parts.get(0);
        String v1 = parts.get(1);
        String v2 = parts.size() > 2 ? parts.get(2) : "";

        String hex = "";
        if (isBinnaryOperator(s))
        {
            if (isContainNumber(v2))
            {
                v2 = intToHex(v2);
                int zeroNum = 8 - v2.length();
                for (int i = 0; i < zeroNum; ++i)
                {
                    v2 = "0" + v2;
                }
                hex = intToHex(m_mapCmdToHex.get(op) + 1) + intToHex((int)(v1.charAt(0) - 'a')) + v2;
            }
            else
            {
                hex = intToHex(m_mapCmdToHex.get(op)) + intToHex((int)(v1.charAt(0) - 'a')) + intToHex((int)(v2.charAt(0) - 'a'));
            }
        }
        else
        {
            if (isContainNumber(v1))
            {
                v1 = intToHex(v1);
                int zeroNum = 8 - v1.length();
                for (int i = 0; i < zeroNum; ++i)
                {
                    v1 = "0" + v1;
                }
                hex = intToHex(m_mapCmdToHex.get(op) + 1) + v1;
            }
            else
            {
                hex = intToHex(m_mapCmdToHex.get(op)) + intToHex((int)(v1.charAt(0) - 'a'));
            }
        }

        ans += hex;
    }

    // 是二元操作符
    Boolean isBinnaryOperator(String strCmdLine)
    {
        return strCmdLine.contains(",");
    }

    Boolean isContainNumber(String v)
    {
        if (v.charAt(0) >= '0' && v.charAt(0) <= '9')
            return true;
        return false;
    }

    String intToHex(String num)
    {
        int decimalValue;
        try {
            decimalValue = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return "Invalid input: Not a valid integer";
        }

        return Integer.toHexString(decimalValue).toUpperCase();
    }

    String intToHex(int n)
    {
        String hex = Integer.toHexString(n).toUpperCase();
        if (hex.length() < 2) {
            hex = "0" + hex;
        }
        return hex;
    }

    List<String> getPart(String strCmdLine)
    {
        List<String> ans = new ArrayList<>();
        int i = 0;

        String temp = "";// 获取操作符
        while (i < strCmdLine.length() && strCmdLine.charAt(i) != ' ')
        {
            temp += strCmdLine.charAt(i);
            ++i;
        }
        ans.add(temp); temp = "";

        i++; // 跳过空格
        // 获取第一个变量
        while (i < strCmdLine.length() && strCmdLine.charAt(i) != ',')
        {
            temp += strCmdLine.charAt(i);
            ++i;
        }
        ans.add(temp); temp = "";

        i++; // 跳过逗号
        // 获取第二个变量
        while (i < strCmdLine.length())
        {
            temp += strCmdLine.charAt(i);
            ++i;
        }
        ans.add(temp); temp = "";

        return ans;
    }

}*/

public class j10022
{
    public static void main(String[] args)
    {
        HexToCmd h = new HexToCmd();
        //CmdToHex c = new CmdToHex();
    }
}
