package j100xx;

import java.util.*;
/** 并集
 6
 2 7 12 17 22 30
 8
 5 10 12 15 22 25 30 50
 */

public class j10028 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> listA = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listA.add(scanner.nextInt());
        }

        int m = scanner.nextInt();
        List<Integer> listB = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            listB.add(scanner.nextInt());
        }

        List<Integer> union = new ArrayList<>(listA);
        for (Integer element : listB) {
            if (!listA.contains(element)) {
                union.add(element);
            }
        }

        for(Integer a : union)
        {
            System.out.print(a+" ");
        }


    }
}