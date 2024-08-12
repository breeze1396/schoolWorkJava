package j100xx;

import java.util.*;
// 差集
public class j10029 {
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

        List<Integer> difference = new ArrayList<>();
        for (Integer element : listA) {
            if (!listB.contains(element)) {
                difference.add(element);
            }
        }

        for(Integer a : difference)
        {
            System.out.print(a+" ");
        }

    }
}