package j20017;

import java.util.Scanner;
import java.util.Stack;

public class j20017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        str = "8-a/+5";
        //str = "-91^2";
        //str = sc.nextLine();

        new Step(str);
    }
}


class Step
{
    public Step(String s)
    {
        str = s;
        index = 0;
        eraseSpace();
        strSize = str.length();
        out();
    }

    public void out()
    {
        //System.out.println(str);
        index = 0;
        pushAndComputebeta();
    }
    void eraseSpace()
    {
        if (str.isEmpty())
            return;

        StringBuilder res = new StringBuilder();
        for (char c : str.toCharArray())
            if (c != ' ') res.append(c);

        str = res.toString();
    }

    //优先级
    int priority(char op)
    {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/' || op == '%') return 2;
        if (op == '^') return 3;
        return 0;
    }

    boolean isOperator(char c)
    {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '^';
    }
    boolean isFunction(String token)
    {
        return token.contains("(");
    }

    String moveToNext()
    {
        StringBuilder res= new StringBuilder();
        int i = index;
        //判断是否是 操作符
        if (isOperator(str.charAt(i)))
        {
            res.append(str.charAt(i));
            index++;
            return res.toString();
        }

        //判断是否是 变量或者函数
        if (Character.isAlphabetic(str.charAt(i))) {
            while (i < strSize && (Character.isAlphabetic(str.charAt(i)) ||
                    Character.isDigit(str.charAt(i))) ) {
                res.append(str.charAt(i));
                i++;
            }
            if (i ==  strSize || isOperator(str.charAt(i)))  {
                index = i;
                return res.toString();
            }
            else {
                while (i < strSize && str.charAt(i) != ')')
                {
                    res.append(str.charAt(i));
                    i++;
                }
                res.append(')');
                ++i;
                if (i == strSize || isOperator(str.charAt(i))) {
                    index = i;
                    return res.toString();
                }
            }
        }

        //判断是否是 数字
        if (Character.isAlphabetic(str.charAt(i)) || Character.isDigit(str.charAt(i))) {
            while (i < strSize && (Character.isAlphabetic(str.charAt(i)) || Character.isDigit(str.charAt(i)))) {
                res.append(str.charAt(i));
                i++;
            }
            if (i == strSize || isOperator(str.charAt(i)))
            {
                index = i;
                return res.toString();
            }
        }

        // 都不是的话表达式有问题
        System.out.println("some thing wrong in move to next");
        return "";

    }
    void pushAndCompute(){}
    void pushAndComputebeta()
{
        //遇到数字，直接入数字栈。
        //遇到字符，分为三种情况：
        //（1）若符号栈为空，直接入符号栈。
        //（2）若该字符运算优先级大于字符栈栈顶元素，直接入符号栈。
        //（3）若该字符运算优先级小于或者等于字符栈栈顶元素，那么需要从数字栈栈顶弹出两个数字，
        //符号栈栈顶弹出一个字符，进行运算，然后将运算结果加入数字栈。
        //此时，需要继续比较index指向的字符与栈顶字符优先级，重复(2)(3)操作，
        //直到该字符运算优先级大于字符栈栈顶元素，直接入符号栈。

        // 函数， 变量，数字，运算符
        while (index < strSize)
        {
            String s = moveToNext();
            if (isFunction(s)) {    // 函数
                stkContent.push("var" + stepIndex);
                System.out.println("var"+ stepIndex++ +"="+s);
            }
            else if (!isOperator(s.charAt(0))) {  // 数字、变量
                stkContent.push(s);
            }
            else  {     // 运算符
                if (stkOperator.empty()) {
                    stkOperator.push(s);
                    if ( str.charAt(index) == '+' || str.charAt(index) == '-')
                    {
                        stkContent.push("var" + stepIndex);
                        System.out.println("var"+ stepIndex++ + "=0" + str.charAt(index++) + moveToNext());

                        String tempOperator = stkOperator.peek();
                        stkOperator.pop();

                        String o1 = stkContent.peek();
                        stkContent.pop();
                        String o2 = stkContent.peek();
                        stkContent.pop();
                        stkContent.push("var" + stepIndex);
                        System.out.println("var"+ stepIndex++ + "=" + o2 +tempOperator +o1);
                    }
                }
                else if (priority(s.charAt(0)) > priority(stkOperator.peek().charAt(0))) {
                    stkOperator.push(s);
                }
                else {
                    String tempOperator = stkOperator.peek();
                    stkOperator.pop();

                    String o1 = stkContent.peek(); stkContent.pop();
                    String o2 = stkContent.peek(); stkContent.pop();
                    stkContent.push("var" + stepIndex);
                    System.out.println("var"+stepIndex++ + "="+o2+tempOperator+o1);

                    index--;
                }
            }
        }

        while(!stkOperator.empty())
        {
            String tempOperator = stkOperator.peek();
            stkOperator.pop();

            String o1 = stkContent.peek();
            stkContent.pop();
            String o2 = stkContent.peek();
            stkContent.pop();
            stkContent.push("var" + stepIndex);
            System.out.println("var"+ stepIndex++ +"="+o2+tempOperator+o1);
        }
    }
    String str="";
    int index = 0;
    int stepIndex = 1;
    int strSize = 0;
    Stack<String> stkContent = new Stack<>();
    Stack<String> stkOperator = new Stack<>();
};

