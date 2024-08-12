import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 3 3  0 0
 3 3  1 11
 2 3  0 12
 2 3  1 11
 2 2  0 10
 2 2  1 5
 1 1  0 6
 1 1  1 3
 1 0  0 3
 1 0  1 3
 2 0  0 3
 2 0  1 3
 3 0  0 8
 3 0  1 8
 */


public class j20004 {
    public static void main(String[] args) {
            new solve();
    }
}


 class biao {
    public biao() {
        int[][] data = {
                {3, 3, 1, 11},
                {2, 3, 0, 12},
                {2, 3, 1, 11},
                {2, 2, 0, 10},
                {2, 2, 1, 5},
                {1, 1, 0, 6},
                {1, 1, 1, 3},
                {1, 0, 0, 3},
                {1, 0, 1, 3},
                {2, 0, 0, 3},
                {2, 0, 1, 3},
                {3, 0, 0, 8},
                {3, 0, 1, 8}
        };

        Map<String,Integer> map = new HashMap<>();
        for (int[] datum : data) {
            String str = datum[0] + " " + datum[1] + " " + datum[2];
            map.put(str, datum[3]);
        }

        // 测试查询
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int a3 = sc.nextInt();
        int a4 = sc.nextInt();
        int a5 = sc.nextInt();

        String str = a1+" "+a2+" "+a5;
        System.out.println(map.get(str));
    }
}


class solve {
    static final int MAX = 260;
    static int index = 0;
    static int numpass = 0;

    static int ans = 0;
    //static int start_c, start_y;
    static Zt[] ztarr = new Zt[MAX];

    static class Zt {
        int left_c;
        int right_c;
        int left_y;
        int right_y;
        int boat_location;  // 1 左边 -1右边
    }
    Scanner scanner = new Scanner(System.in);
    public solve() {
        ztarr[index] = new Zt();
        ztarr[index].left_y = scanner.nextInt();
        ztarr[index].left_c = scanner.nextInt();

       ztarr[index].right_y = scanner.nextInt();
        ztarr[index].right_c = scanner.nextInt();
        ztarr[index].right_y = 3-ztarr[index].left_y ;
        ztarr[index].right_c = 3-ztarr[index].left_c;

        int loc = scanner.nextInt();
        if(loc == 0) loc = -1;
        ztarr[index].boat_location = loc;
        handle(ztarr[index]);
        //System.out.printf("已为您找到%d条过河路径！并且已全部加载完毕！\n", numpass);
        System.out.println(ans);
    }

    static int handle(Zt t) {
        // 是否达到目标转态
        if (t.right_c == 3 && t.right_y == 3) {
            numpass++;
            //System.out.printf("\n找到第%d条路径！\n", numpass);
            //System.out.println("左传\t左野\t右传\t右野\t船");
           /* for (int i = 0; i <= index; i++) {
                System.out.printf("%2d\t", ztarr[i].left_c);
                System.out.printf("%2d\t", ztarr[i].left_y);
                System.out.printf("%2d\t", ztarr[i].right_c);
                System.out.printf("%2d\t", ztarr[i].right_y);
                System.out.printf("%2d\t", ztarr[i].boat_location);
                System.out.println();
            }*/
            //System.out.println(index);
            ans = index;
            // 找到多条路径的关键一
            return 0;
        }
        // 是否重复操作
        for (int i = 0; i < index; i++) {
            if (t.left_c == ztarr[i].left_c && t.left_y == ztarr[i].left_y) {
                if (t.boat_location == ztarr[i].boat_location) {
                    return 0;
                }
            }
        }
        // 人数是否合理吗
        if (t.left_c < 0 || t.left_y < 0 || t.right_c < 0 || t.right_y < 0) {
            return 0;
        }
        // 传教士是否被吃
        if ((t.left_c < t.left_y && t.left_c != 0) || (t.right_c < t.right_y && t.right_c != 0)) {
            return 0;
        }

        // 定义一个临时节点
        Zt tt = new Zt();

        // 两个传教士过河
        tt.left_c = t.left_c - 2 * t.boat_location;
        tt.left_y = t.left_y;
        tt.right_c = t.right_c + 2 * t.boat_location;
        tt.right_y = t.right_y;
        tt.boat_location = (-t.boat_location);
        index = index + 1;
        ztarr[index] = tt;
        handle(ztarr[index]);
        index = index - 1;

        // 两个野人过河
        tt.left_c = t.left_c;
        tt.left_y = t.left_y - 2 * t.boat_location;
        tt.right_c = t.right_c;
        tt.right_y = t.right_y + 2 * t.boat_location;
        tt.boat_location = (-t.boat_location);
        index = index + 1;
        ztarr[index] = tt;
        handle(ztarr[index]);
        index = index - 1;

        // 一个野人，一个传教士过河
        tt.left_c = t.left_c - 1 * t.boat_location;
        tt.left_y = t.left_y - 1 * t.boat_location;
        tt.right_c = t.right_c + 1 * t.boat_location;
        tt.right_y = t.right_y + 1 * t.boat_location;
        tt.boat_location = (-t.boat_location);
        index = index + 1;
        ztarr[index] = tt;
        handle(ztarr[index]);
        index = index - 1;

        // 一个传教士过河
        tt.left_c = t.left_c - 1 * t.boat_location;
        tt.left_y = t.left_y;
        tt.right_c = t.right_c + 1 * t.boat_location;
        tt.right_y = t.right_y;
        tt.boat_location = (-t.boat_location);
        index = index + 1;
        ztarr[index] = tt;
        handle(ztarr[index]);
        index = index - 1;

        // 一个野人过河
        tt.left_c = t.left_c;
        tt.left_y = t.left_y - 1 * t.boat_location;
        tt.right_c = t.right_c;
        tt.right_y = t.right_y + 1 * t.boat_location;
        tt.boat_location = (-t.boat_location);
        index = index + 1;
        ztarr[index] = tt;
        handle(ztarr[index]);
        index = index - 1;
        // 找到多条路径的关键二
        return 0;
    }
}
