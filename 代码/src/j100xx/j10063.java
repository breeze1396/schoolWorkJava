package j100xx;

import java.util.Scanner;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
// 13-45/34+22-36*20+41-8 ok
public class j10063 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        BigDecimal result=cal(str);
        System.out.format("%.5f\n",result);
    }
    public static BigDecimal cal(String str)
    {
        List<String> list=new ArrayList<>();
        char[] arr=str.toCharArray();
        StringBuilder stringBuilder=new StringBuilder();
        for(char c : arr)
        {
            if(c>='0'&&c<='9') {
                stringBuilder.append(c);
            }else if(c=='.')
            {
                stringBuilder.append(c);
            }
            else if(c=='+'||c=='-'||c=='*'||c=='/'||c=='('||c==')') {
                if(stringBuilder.length()>0)
                {
                    list.add(stringBuilder.toString());
                    stringBuilder.setLength(0);
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
        if(stringBuilder.length()>0)
        {
            list.add(stringBuilder.toString());
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
                        newStack.push(b2.divide(b1,9,BigDecimal.ROUND_HALF_UP));
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