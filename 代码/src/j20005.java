import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Scanner;

class FrogJump {
    static final int EMPTY = 0; // 表示空位
    static final int GREEN = 1; // 表示绿青蛙
    static final int RED = 2; // 表示红青蛙
    static final int NUM = 7; // 表示石头数
    static final int MAXSTEP = 50; // 完成移位可能需要的步数

    static int[] stone = {GREEN, GREEN, GREEN, EMPTY, RED, RED, RED};
    static int[] step = new int[MAXSTEP];

    static int ans = -1;

    public static void main(String[] args) {
        Arrays.fill(step, -1);
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < NUM; ++i)
        {
            stone[i] = sc.nextInt();
        }
        recursiveBacktrack(0);
        System.out.println(ans);
    }

    // 递归回溯法求解
    static void recursiveBacktrack(int n) {
        if (isSuccess()) {
            printResult();
        } else {
            for (int i = 0; i < NUM; i++) {
                if (canShift(i)) {
                    int originalEmptyPos = whereEmpty();
                    step[n] = i;
                    frogShift(i);
                    recursiveBacktrack(n + 1);
                    frogShift(originalEmptyPos);
                }
            }
        }
    }

    // 判断在第i个石头上青蛙是否能移位
    static boolean canShift(int i) {
        int emptyPos = whereEmpty();
        switch (stone[i]) {
            case GREEN:
                return emptyPos > i && emptyPos <= i + 2;
            case RED:
                return emptyPos < i && emptyPos >= i - 2;
            default:
                return false;
        }
    }

    // 在第i块石头上的青蛙进行移位
    static void frogShift(int i) {
        int emptyPos = whereEmpty();
        stone[emptyPos] = stone[i];
        stone[i] = EMPTY;
    }

    // 空位的位置
    static int whereEmpty() {
        for (int i = 0; i < NUM; i++) {
            if (stone[i] == EMPTY) {
                return i;
            }
        }
        return -1; // 不应该到达这里，但为了防止编译错误添加此行
    }

    // 判断是否已经完成所有移位
    static boolean isSuccess() {
        return stone[0] == RED &&
                stone[1] == RED &&
                stone[2] == RED &&
                stone[3] == EMPTY &&
                stone[4] == GREEN &&
                stone[5] == GREEN &&
                stone[6] == GREEN;
    }

    // 打印结果
    static void printResult() {
        int stepSize = 0;
        for (int i = 0; i < MAXSTEP; i++) {

            if (step[i] == -1) {
                break;
            }
            stepSize++;
            //System.out.print(step[i] + " ");
        }
        ans = stepSize;
    }
}