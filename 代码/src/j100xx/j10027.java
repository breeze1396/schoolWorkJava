package j100xx;

import java.util.*;

/*交集
 6
 2 7 12 17 22 30
 8
 5 10 12 15 22 25 30 50
*/
public class j10027 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        List<Integer> listA = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            listA.add(scanner.nextInt());
        }

        int M = scanner.nextInt();
        List<Integer> listB = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            listB.add(scanner.nextInt());
        }

        List<Integer> intersection = new ArrayList<>();
        for (Integer element : listA) {
            if (listB.contains(element)) {
                intersection.add(element);
            }
        }

        for(Integer a : intersection)
        {
            System.out.print(a+" ");
        }

    }
}