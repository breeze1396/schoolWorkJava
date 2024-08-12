package j100xx;/* 	从输入的字符串中提取出临时变量名，其中临时变量名的格式为: 以字符串var开头，然后接着有1个或多个数字。 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;
public class j10011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Pattern pattern = Pattern.compile("var\\d*");
        Matcher matcher = pattern.matcher(str);

        List<String> matchesList = new ArrayList<>();
        while (matcher.find()) {
            matchesList.add(matcher.group());
        }

        for (String match : matchesList) {
            System.out.println(match);
        }

    }
}