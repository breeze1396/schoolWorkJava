package j20016;

import java.util.HashSet;
import java.util.Scanner;
/*
6 10
1 2
1 3
1 5
2 3
2 5
2 6
3 4
3 5
3 6
4 6
* */


class j20016 {
    public static void main(String[] args) {
        new j20016();
    }

    j20016() {
        read();
        //test();
        for(int i = 0; i < N; i++)
        {
            solve(i, 0, "");
        }
        System.out.println(ans);
        System.out.print(times);
    }

    void solve(int curNode, int len, String path) {
        times++;
        if(len == N-1) return;
        if (set.contains(path)) return;

        set.add(path);

        if(path.contains(String.valueOf(curNode)))
        {
            ans = Math.max(ans, len);
            return;
        }

        for (int i = 0; i < N; i++)
        {
            if(arr[curNode][i] == 1)
            {
                solve(i, len+1, path+ (i - 1));
            }
        }
    }

    void read()
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a-1][b-1] = 1;
            arr[b-1][a-1] = 1;
        }
    }
    void test()
    {
        String test =
                "6 10\n" +
                "1 2\n" +
                "1 3\n" +
                "1 5\n" +
                "2 3\n" +
                "2 5\n" +
                "2 6\n" +
                "3 4\n" +
                "3 5\n" +
                "3 6\n" +
                "4 6";
        Scanner sc = new Scanner(test);
        N = sc.nextInt();
        arr = new int[N][N];
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a-1][b-1] = 1;
            arr[b-1][a-1] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    int[][] arr;
    HashSet<String> set = new HashSet<>();
    int N; // 节点数
    int ans = 0;
    int times = 0;
}