package j100xx;

import java.util.Scanner;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
69.0
54 91 12 18 76

882.0
106 91 56 54 80

//  案例通过未果
*/
public class j10065 {
    private static final String[] op = {"+", "-", "*", "/"};
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        double target = sc.nextDouble();
        double[] nums = new double[5];

        for(int i =0; i < 5; ++i)
        {
            nums[i] = sc.nextDouble();
        }

        findCombinations(nums, target);
    }

    public static void findCombinations(double[] nums, double target) {
        for(int opChoice1 = 0; opChoice1 < 4; ++opChoice1)
        {
            for(int opChoice2 = 0; opChoice2 < 4; ++opChoice2)
            {
                for(int opChoice3 = 0; opChoice3 < 4; ++opChoice3)
                {
                    for(int opChoice4 = 0; opChoice4 < 4; ++opChoice4)
                    {
                        String t = nums[0]+op[opChoice1]+
                                nums[1]+op[opChoice2]+
                                nums[2]+op[opChoice3]+
                                nums[3]+op[opChoice4]+
                                nums[4];
                        if(Math.abs(target - cal(t).doubleValue()) < 1e-5)
                        {
                            //System.out.println(cal(t).doubleValue());
                            System.out.println( op[opChoice1]+" "+
                                                op[opChoice2]+" "+
                                                op[opChoice3]+" "+
                                                op[opChoice4]);
                            return;
                        }
                    }
                }
            }
        }
    }



    // 返回一个数值
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