package j100xx;/* 	间隔符规范化。输入一行字符串，该字符串使用空格作为单词、符号等之间的间隔符。
然而由于用户操作的问题，在录入间隔符时，可能输入了多个空格，现要求对输入的字符串进行处理，
清除字符串的首尾空格，并且确保字符串中的间隔符只能有一个空格。*/

import java.util.Scanner;

public class j10012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String trimmedInput = sc.nextLine().trim();

        String result = trimmedInput.replaceAll("\\s+", " ");

        System.out.println(result);
    }

}