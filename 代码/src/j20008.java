import java.util.Arrays;
import java.util.Scanner;
/*
10
100 92 88 93 95 89 78 86 92 80
* */
public class j20008 {
    private static int _N;

    static int f(int[] arr, int i, int scores)
    {
        if(i >= _N) return 0;
        int see = 0;
        if(arr[i] <= scores) {
            see = f(arr, i + 1, arr[i]) + 1;
        }
        int nosee = f(arr, i + 1, scores);
        return Math.max(see, nosee);
    }

    static void g2()
    {
        Scanner sc  = new Scanner(System.in);
        _N = sc.nextInt();

        int[] scores = new int[_N];
        for (int i = 0; i < _N; ++i)
        {
            scores[i] = sc.nextInt();
        }
        System.out.println(f(scores, 0, Integer.MAX_VALUE));
    }

    public static int maxMeetings(int[] scores) {
        int N = scores.length;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (scores[j] <= scores[i]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    public static void g1()
    {
        Scanner sc  = new Scanner(System.in);
        _N = sc.nextInt();

        int[] scores = new int[_N];
        for (int i = 0; i < _N; ++i)
        {
            scores[i] = sc.nextInt();
        }
        System.out.println(maxMeetings(scores));
    }

    public static void main(String[] args) {
        g1();
    }
}