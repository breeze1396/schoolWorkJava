package j100xx;/*	二进制指令序列解码成字符串源代码*/

import java.util.*;
/*
5
  mov f,       h
    add m      ,     67890
   jmp    25688
 div  k  ,  b
 je        z
*/


class CmdToHex
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
        //int line = 1;
        String[] strings = new String[line];
        for(int i = 0; i < line; ++i)
        {

            strings[i] = sc.nextLine().trim().replaceAll("\\s+", " ").replace(", ", ",");
        }
        for(int i = 0; i < line; ++i)
            TransformToHex(strings[i]);

        System.out.print(ans);
    }
    public void TransformToHex(String s)
    {
        List<String> parts = getPart(s);
        String op = parts.get(0);
        String v1 = parts.get(1);
        String v2 = parts.size() > 2 ? parts.get(2) : "";

        String hex;
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
        return v.charAt(0) >= '0' && v.charAt(0) <= '9';
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

}

public class j10023
{
    public static void main(String[] args)
    {
            CmdToHex c = new CmdToHex();
    }
}
