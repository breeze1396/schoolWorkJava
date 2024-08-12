package j100xx;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class j10015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String y = sc.next();
        String m = sc.next();
        String d = sc.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy M d");
        LocalDate date = LocalDate.parse(y+" " + m+" "+d, formatter);
        int dayOfYear = date.getDayOfYear();
        System.out.println(dayOfYear);
    }
}