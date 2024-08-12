package j20020;
import java.math.BigDecimal;
import java.util.*;

/*
14
00000: 1,var1=0+0
00001: 2,result=var1
00002: 1,var1=0+1
00003: 2,i=var1
00004: 1,var2=0+100
00005: 3,IF,i<=var2,TRUEJMP:6,FALSEJMP:13
00006: 1, var1=result+i
00007: 2, result=var1
00008: 1, var1=0+i
00009: 1, var2=0+1
00010: 1, var1=var1+var2
00011: 2, i=var1
00012: 4, JMP:4
00013: 1, var1=result+0
* */
/*
17
00000: 1,var1=0+0
00001: 2,result=var1
00002: 1,var1=0+1
00003: 2,i=var1
00004: 1,var2=0+300
00005: 3,IF,i<=var2,TRUEJMP:6,FALSEJMP:16
00006: 1,var1=i+2.1
00007: 1,var2=i+5.6
00008: 1,var3=var1/var2
00009: 1,var4=result+var3
00010: 2,result=var4
00011: 1,var1=0+i
00012: 1,var2=0+1
00013: 1,var1=var1+var2
00014: 2,i=var1
00015: 4,JMP:4
00016: 1,var1=result+0
*/


class Solve {
    private String[] cmds;
    private HashMap<String,String> hashMap = new HashMap<>();
    public static void main(String[] args) {
        new Solve();
    }
    public Solve() {
        readDataFromConsole();
        //testDataFromConsole();
        analysis();
        printResult();
    }
    // 解析数据，会修改哈希表值
    private void analysis()
    {
        int lines = 0;
        int end = cmds.length;

        while (lines < end)
        {
            String cmd = cmds[lines];
            switch (cmd.charAt(0))
            {
                case '1':constantAssign(cmd); lines++;  break;
                case '2':varAssignVar(cmd); lines++;    break;
                case '3':lines = whereTojump(cmd);      break;
                case '4':lines = jmp(cmd);              break;
            }
        }
    }
    // 1 常数赋值
    void constantAssign(String cmd)
    {
        int equalIndex = cmd.indexOf("=");
        String var = cmd.substring(2, equalIndex);
        String t = replaceVar(cmd.substring(equalIndex+1));
        String value = compute(t).toString();
        if(cmd.contains("."))  value = "D"+value;
        else  value = "I"+value;

        if (hashMap.containsKey(var)) {
            hashMap.replace(var, value);
        } else {
            hashMap.put(var,value);
        }
    }

    // 2 变量赋值,把变量换成值计算
    void varAssignVar(String cmd)
    {
        int equalIndex = cmd.indexOf("=");
        String var = cmd.substring(2, equalIndex);
        String value = cmd.substring(equalIndex+1);
        String v = replaceVar(value);
        if(v.contains("."))
            hashMap.put(var, "D"+v);
        else
            hashMap.put(var, "I"+v);

    }

    boolean isOperation(char c)
    {
        return c == '+' || c == '-' || c == '/' || c == '*';
    }

    boolean isJudgeOperation(char c) { return c == '<' || c == '>' || c == '='; }
    // 3 判断 jmpToWhere
    // 3,IF,i<=var2,TRUEJMP:6,FALSEJMP:13
    int whereTojump(String str)
    {
        str = str.substring(str.indexOf("IF,")+3);
        int judgeIndex = str.indexOf(",");
        String judgement = str.substring(0, judgeIndex);
        boolean isTrue = judgeIsTrue(judgement);

        String line;
        if(isTrue)
        {
            line = str.substring(str.indexOf("TRUEJMP:")+8, str.indexOf("FALSEJMP:")-1);
        }
        else
        {
            line = str.substring(str.indexOf("FALSEJMP:")+9);
        }
        return Integer.parseInt(line);
    }

    boolean judgeIsTrue(String judgement)
    {
        boolean flag = false;

        // <, <=, ==, >=, >
        // 提取前面的字符
        StringBuilder sb1 = new StringBuilder();
        int index = 0;
        while ( !isJudgeOperation(judgement.charAt(index)) )
        {
            sb1.append(judgement.charAt(index++));
        }

        // 提取后面的字符
        StringBuilder sb2 = new StringBuilder();
        index = judgement.length()-1;
        while ( !isJudgeOperation(judgement.charAt(index)) )
        {
            sb2.append(judgement.charAt(index--));
        }

        String s1 = sb1.toString();
        String s2 = sb2.reverse().toString();

        if(judgement.contains("<"))
        {
            if(judge(s1, s2) < 0) flag = true;
        }

        if(judgement.contains(">"))
        {
            if(judge(s1, s2) > 0) flag = true;
        }

        if(judgement.contains("="))
        {
            if(judge(s1, s2) == 0) flag = true;
        }

        return flag;
    }


    //  small  -1, 0 ,1 big
    int judge(String str1, String str2)
    {
        String v1 =  replaceVar(str1);
        String v2 =  replaceVar(str2);

        double d1 = Double.parseDouble(v1);
        double d2 = Double.parseDouble(v2);

        return Double.compare(d1, d2);
    }

    private String replaceVar(String str1) {
        String newValue = str1;
        int index = 0;
        while (index < str1.length())
        {
            StringBuilder sb = new StringBuilder();
            while (index < str1.length())
            {
                if(isOperation(str1.charAt(index))) break;
                sb.append(str1.charAt(index));
                index++;
            }
            if (hashMap.containsKey(sb.toString()))
                newValue = newValue.replace(sb, hashMap.get(sb.toString()).substring(1) );
            index++;
        }

       return compute(newValue).toString();
    }


    // 4 jmpToWhere
    int jmp(String str)
    {
        return Integer.parseInt(str.substring(str.indexOf("JMP:")+4));
    }

    // 打印result
    void printResult()
    {
        String result = hashMap.get("result");
        String value = result.substring(1);
        if(result.charAt(0) == 'I')
        {
            System.out.println(Integer.parseInt(value));
        }
        else
        {
            System.out.printf("%.5f", Double.parseDouble(value));
        }
    }



    // 读取数据, 修改cmds
    void readDataFromConsole()
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        cmds = new String[N];
        for(int i = 0; i < N; ++i)
        {
            cmds[i] = normalize(sc.nextLine());
        }
    }

    // 测试数据
    /*void testDataFromConsole()
    {
        String cmd =
                """
                        00000: 1,var1=0+0
                        00001: 2,result=var1
                        00002: 1,var1=0+1
                        00003: 2,i=var1
                        00004: 1,var2=0+300
                        00005: 3,IF,i<=var2,TRUEJMP:6.FALSEJMP:16
                        00006: 1,var1=i+2.1
                        00007: 1,var2=i+5.6
                        00008: 1,var3=var1/var2
                        00009: 1,var4=result+var3
                        00010: 2,result=var4
                        00011: 1,var1=0+i
                        00012: 1,var2=0+1
                        00013: 1,var1=var1+var2
                        00014: 2,i=var1
                        00015: 4,JMP:4
                        00016: 1,var1=result+0
                        """;
        cmds = cmd.split("\n");
        for(int i = 0; i < cmds.length; ++i)
        {
            cmds[i] = normalize(cmds[i]);
        }
    }*/


    // 读取数据格式修改
    private String normalize(String str)
    {
        return str.replaceAll(" ", "").substring(str.indexOf(":")+1).trim();
    }

    public static BigDecimal compute(String str)
    {
        List<String> list=new ArrayList<>();
        char[] arr=str.toCharArray();
        StringBuffer sb=new StringBuffer();
        for(char c:arr)
        {
            if(c>='0'&&c<='9') {
                sb.append(c);
            }else if(c=='.')
            {
                if(sb.indexOf(".")>0)
                {
                    //throw new RuntimeException("非法字符");
                    return new BigDecimal(0);
                }
                sb.append(c);
            }
            else if(c=='+'||c=='-'||c=='*'||c=='/'||c=='('||c==')') {
                if(sb.length()>0)
                {
                    list.add(sb.toString());
                    sb.setLength(0);
                }
                list.add(c+"");
            }
            else if(c==' ')
            {
                continue;
            }else {
                throw new RuntimeException("非法字符");
            }
        }
        if(sb.length()>0)
        {
            list.add(sb.toString());
        }
        List<String> strList =new ArrayList<>();
        Stack<String> stack=new Stack<>();
        String temp;
        for(String s:list)
        {
            if(s.equals("("))
            {
                stack.push(s);
            }
            else if(s.equals(")")) {
                while(!(temp=stack.pop()).equals("("))
                {
                    strList.add(temp);
                }
            }
            else if (s.equals("*")||s.equals("/")) {
                while(!stack.isEmpty()) {
                    temp=stack.peek();
                    if(temp.equals("*")||temp.equals("/"))
                    {
                        stack.pop();
                        strList.add(temp);
                    }else {
                        break;
                    }
                }
                stack.push(s);
            }else if(s.equals("+")||s.equals("-"))
            {
                while(!stack.isEmpty()) {
                    temp=stack.peek();
                    if(!temp.equals("("))
                    {
                        stack.pop();
                        strList.add(temp);
                    }else {
                        break;
                    }
                }
                stack.push(s);
            }
            else {
                strList.add(s);
            }
        }
        while(!stack.isEmpty()) {
            strList.add(stack.pop());
        }
        Stack<BigDecimal>newStack=new Stack<>();
        for(String s:strList)
        {
            if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")) {
                BigDecimal b1=newStack.pop();
                BigDecimal b2=newStack.pop();
                switch(s){
                    case "+":
                        newStack.push(b2.add(b1));
                        break;
                    case "-":
                        newStack.push(b2.subtract(b1));
                        break;
                    case "*":
                        newStack.push(b2.multiply(b1));
                        break;
                    case "/":
                        newStack.push(b2.divide(b1,50,BigDecimal.ROUND_HALF_UP));
                        break;
                }
            }
            else {
                newStack.push(new BigDecimal(s));
            }
        }
        return newStack.peek();
    }
}