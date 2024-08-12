package j100xx;

import java.util.Scanner;
import java.util.HashMap;
public class j10017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                System.out.println(c);
                return;
            } else {
                map.put(c, 1);
            }
        }
    }

}