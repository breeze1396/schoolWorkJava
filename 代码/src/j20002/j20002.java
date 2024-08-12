package j20002;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 这题答案只有注释的old—solve是对的，其它部分是有问题的，案例在足够离谱的时候会错误
// 数据量不大于30*30的情况，且1的数量相对于小于0的时候会正确
// 时间复杂度为N*N + C（turns，size）* 3^N
// N = 7 时， size = 36, 会创建大约 50000 point
// 不想改进了，使用一个类肯定简单很多

/*
28
1 0 0 0 0 0 0 1 0 0 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 1 0 1 0 0 0 1 0 1 0
1 0 1 0 0 0 0 1 1 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0
1 0 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 1 1 0 0 0 0 0 1 1 0 0 0 0 1 0 0
1 0 0 1 0 0 0 0 0 1 0 1 1 0 0 1 0 0 0 1 0 1 0 0 0 0 0 0
0 0 0 0 1 0 0 0 0 1 0 1 0 1 0 0 0 0 0 0 1 0 0 0 0 0 0 1
0 0 1 0 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0
0 1 0 0 0 1 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0 0 0 1 0 0 1
0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 1 0 1 0 0 1 0 0 0 0 0 0 0 0 0 1 0 0 0 0 1 0 0 0 0 1 0
1 0 0 0 0 0 0 1 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0
1 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 1 0 0 0 0 0
0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 1 0 0
0 1 1 0 0 0 0 0 1 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1
0 0 1 0 0 0 1 0 0 0 0 0 0 1 1 0 0 1 1 1 0 1 0 0 0 0 0 1
1 0 0 1 0 0 0 0 0 0 0 0 1 1 0 0 0 0 1 0 0 0 0 1 0 0 0 0
0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 1 0 0 0 0
0 1 0 0 0 0 1 0 0 0 0 0 1 0 0 0 1 1 0 0 0 0 0 1 1 0 0 0
0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 1 1 1 0 1 0 1 0 0 1 0 0 0 0 0 0 1 0 0 0 0
1 1 1 1 0 0 1 1 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 1 1 0 0 1 0 0 0 1 1 1 0 0 0 0 0 0 0 0 0
0 1 0 1 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0
0 1 1 0 0 0 0 0 0 0 1 1 0 0 0 1 0 0 0 0 1 0 1 0 0 1 0 0
0 0 0 1 0 1 0 0 1 1 0 1 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0
0 0 1 1 0 0 1 1 0 1 1 1 0 0 0 0 1 0 0 0 0 0 1 0 0 0 0 0
10 0
20 24

8
1 1 0 0 1 0 0 0
1 0 0 0 0 1 0 1
0 1 0 1 0 1 0 0
0 0 0 0 1 0 0 0
0 0 0 1 0 0 0 1
0 0 0 0 0 1 1 0
1 0 1 0 0 0 0 0
0 0 0 0 0 0 0 0
0 2
4 4

9
0 1 0 0 0 0 0 0 0
1 0 1 1 0 1 0 0 0
0 0 0 0 1 0 0 0 1
0 0 0 1 0 1 1 0 1
1 1 0 0 0 0 0 1 1
1 1 0 0 0 0 0 1 0
0 0 0 0 1 0 0 1 0
0 1 0 1 1 1 1 1 1
1 1 0 1 0 0 1 0 0
0 2
4 6


4
0 0 0 0
0 1 0 0
0 0 0 0
1 0 0 0
0 0
3 3

3
0 0 0
0 0 0
1 0 0
0 0
2 2
* */
class pointe {
    public int row;
    public int col;
    public int direction;
    public int turnTimes;
    public int depth;

    public ArrayList<int[]> path;
    pointe(int r, int c, int d, int turnCount, int depth_) {
        row = r;
        col = c;
        direction = d;
        turnTimes = turnCount;
        depth = depth_;
        path = new ArrayList<int[]>();
    }
}

class PointEasy {
    public int row;
    public int col;
    public int direction;
    public int turnTimes;
    public int depth;
    PointEasy(int r, int c, int d, int turnCount,int depth_) {
        row = r;
        col = c;
        direction = d;
        turnTimes = turnCount;
        depth = depth_;
    }
}

class j2 {
    public static int startX = 0;
    public  static int startY = 0;
    public static int endX = 0;
    public static int endY = 0;
    public static int N = 0;
    public static int[][] map;

    public static int ansTurns = -1;
    public static int ansDepth = -1;
    static final int[][] directions = { {1, 0},{0, 1} ,{-1, 0}, {0, -1} };        // 定义方向数组，分别表示下右上左四个方向

    public j2()
    {
        read();
        int[][] newMap = copy(map);
        pointe a = solveFindShortestLength(newMap, new int[]{startX, startY}, new int[]{endX, endY});
        if (a != null) {
            ansDepth = a.depth;
            ansTurns = a.turnTimes;
        }
    }

    public int getTurns()
    {
        return ansTurns;
    }
    public int getDepth()
    {
        return ansDepth;
    }

    static void read()
    {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt(); // 输入矩阵大小N
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scanner.nextInt(); // 读取矩阵元素
            }
        }

        startX = scanner.nextInt(); // 起始行
        startY = scanner.nextInt(); // 起始列
        endX = scanner.nextInt(); // 终点行
        endY = scanner.nextInt(); // 终点列
    }


    // 时间复杂度 N^2, 找到最短路径
    public static pointe solveFindShortestLength(int[][] maze, int[] start, int[] end) {
        Queue<pointe> queue = new LinkedList<>();
        queue.add(new pointe(start[0],start[1],-1,-1,0));

        while (!queue.isEmpty()) {
            pointe current = queue.poll();

            if (current.row == end[0] && current.col == end[1]) {
                return current;
            }

            if(current.direction!=-1)
            {
                int[] direction = directions[current.direction];
                pointe newPoint = new pointe(current.row + direction[0], current.col + direction[1], current.direction,
                        current.turnTimes, current.depth+1);
                if (newPoint.row >= 0 && newPoint.row < maze.length &&
                        newPoint.col >= 0 && newPoint.col < maze[0].length &&
                        maze[newPoint.row][newPoint.col] == 0) {
                    queue.add(newPoint);
                    maze[newPoint.row][newPoint.col] = 2;
                    newPoint.path = new ArrayList<>(current.path);
                    newPoint.path.add(new int[]{newPoint.row, newPoint.col});
                }
            }

            for (int i = 0; i < 4; ++i) {
                if (i == current.direction)
                    continue;
                int[] direction = directions[i];
                int turnTimes = current.turnTimes+1;
                pointe newPoint = new pointe(current.row + direction[0], current.col + direction[1], i,turnTimes,current.depth+1);
                if (newPoint.row >= 0 && newPoint.row < maze.length &&
                        newPoint.col >= 0 && newPoint.col < maze[0].length &&
                        maze[newPoint.row][newPoint.col] == 0) {
                    queue.add(newPoint);
                    maze[newPoint.row][newPoint.col] = 2;
                    newPoint.path = new ArrayList<>(current.path);
                    newPoint.path.add(new int[]{newPoint.row, newPoint.col});
                }
            }
        }
        // 如果搜索结束还没有找到路径，返回null
        return null;
    }

    private static int[][] copy(int[][] co)
    {
        int size = co.length;
        int[][] newCp = new int[size][size];
        for(int i = 0; i < size;i++)
        {
            System.arraycopy(co[i], 0, newCp[i], 0, size);
        }
        return newCp;
    }
}

 class Point {
    public byte row;
    public byte col;
    boolean isEnd;
    public byte direction;
    public short turnTimes;
    public short depth;
    public byte[][] map;
    Point(byte r, byte c, byte[][] grid, byte dir, short turnCount, short deep, boolean end) {
        row = r;
        col =c;
        map = grid;
        direction = dir;
        turnTimes = turnCount;
        depth =  deep;
        isEnd = end;
    }
}

public class j20002 {
    static byte startX = 0;
    static byte startY = 0;
    static byte endX = 0;
    static byte endY = 0;
    static byte N = 0;       // map 的长和宽
    static byte[][] map;     // 存储原始map
    static short ansDepth = 10000;
    static short ansTurns = 10000;

    static final short[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};        // 定义方向数组，分别表示上下左右四个方向

    public static void main(String[] args) {
        test();
        //read();

        j2 j222 = new j2();

        startY = (byte) j2.startY;
        startX = (byte) j2.startX;
        endY = (byte) j2.endY;
        endX = (byte) j2.endX;
        map = new byte[j2.N][j2.N];
        for (int i = 0; i < j2.N; i++) {
            for (int j = 0; j < j2.N; j++) {
                map[i][j] = (byte) j2.map[i][j];
            }
        }

        ansDepth = (short) j222.getDepth();
        ansTurns = (short) j222.getTurns();
        j222 = null;

        if(ansDepth == -1) {
            System.out.println("-1 -1");
            return;
        }


        solve(map);
    }

    static void read()
    {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextByte(); // 输入矩阵大小N
        map = new byte[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scanner.nextByte(); // 读取矩阵元素
            }
        }

        startX = scanner.nextByte(); // 起始行
        startY = scanner.nextByte(); // 起始列
        endX = scanner.nextByte(); // 终点行
        endY = scanner.nextByte(); // 终点列

        map[startX][startY] = 4;
        map[endX][endY] = 5;
    }
    static void test()
    {
        map = new byte[][]
                {
                        { 0, 0, 1, 0, 0},
                        { 0, 0, 1, 0, 0},
                        { 0, 0, 0, 0, 0},
                        { 0, 0, 0, 1, 0},
                        { 1, 0, 0, 0, 0}
                };// 创建N * N的地图矩阵
        startX = 0;
        startY = 0;
        endX = 4;
        endY = 4;
        map[startX][startY] = 4;
        map[endX][endY] = 5;
    }

    public static void solve(byte[][] maze) {
        Queue<Point> queue = new LinkedList<>();
        Point startP = new Point(startX, startY, maze.clone(), (byte) -1,(byte)-1, (byte)0, false);
        queue.offer(startP);

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (cur.isEnd) {
                if(cur.depth <= ansDepth  && cur.turnTimes <= ansTurns)
                {
                    ansTurns = cur.turnTimes;
                    ansDepth = cur.depth;
                }
                continue;
            }

            for (int i = 0; i < 4; ++i) {
                int turn;
                if(cur.direction == i) turn = cur.turnTimes;
                else turn = cur.turnTimes+1;


                if(turn > ansTurns) continue;

                byte newRow = (byte)(cur.row + directions[i][0]);
                byte newCol = (byte)(cur.col + directions[i][1]);

                int dis = Math.abs(newRow-endX) + Math.abs(newCol-endY);
                if(dis > ansDepth) continue;


                if (isValidLocation(newRow, newCol, cur.map)) {
                    byte[][] map = copy(cur.map);
                    boolean isToEnd = newRow == endX && newCol == endY;
                    if(!isToEnd)
                        map[newRow][newCol] = 2;

                    Point nextPoint = new Point(newRow, newCol, map, (byte)i, (byte)turn, (byte)(cur.depth+1), isToEnd);

                    if(nextPoint.depth <= ansDepth && nextPoint.turnTimes <= ansTurns)
                    {
                        queue.offer(nextPoint);
                    }
                }
            }
        }

        System.out.print(ansDepth+" ");
        System.out.println(ansTurns);
    }


    /*public static void old_solve(byte[][] maze) {
        Queue<Point> queue = new LinkedList<>();
        Point startPoint = new Point(startX,startY, maze.clone(), (byte)-1,(byte)0,(byte)0, false);

        queue.offer(startPoint);
        List<Point> ansList = new ArrayList<>();

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            if (cur.isEnd) {
                System.out.println("Found");
                ansTurns = cur.turnTimes;
                ansDepth = cur.depth;
                ansList.add(cur);
                continue;
            }

            for (int i = 0; i < 4; ++i) {
                int turn;
                if(cur.direction == i) turn = cur.turnTimes;
                else turn = cur.turnTimes+1;

                if(turn > 10) continue;

                int newRow = cur.row + directions[i][0];
                int newCol = cur.col + directions[i][1];

                if (isValidLocation(newRow, newCol, cur.map)) {
                    int[][] map = copy(cur.map);
                    boolean isToEnd = newRow == endX && newCol == endY;
                    if(!isToEnd)
                        map[newRow][newCol] = 2;
                    
                    Point nextPoint = new Point(newRow, newCol, map, i, turn, cur.depth+1, isToEnd);

                    if(nextPoint.depth > ansDepth || nextPoint.turnTimes > ansTurns)
                    {
                        continue;
                    }

                    queue.offer(nextPoint);
                   // print(cur.map);
                    //print(nextPoint.map);
                }
            }
        }

         for (var a : ansList)
         {
             System.out.println(a.depth+"  "+a.turnTimes);
             print(a.map);
         }
    }*/

    private static byte[][] copy(byte[][] co)
    {
        int size = co.length;
        byte[][] newCp = new byte[size][size];
        for(int i = 0; i < size;i++)
        {
            System.arraycopy(co[i], 0, newCp[i], 0, size);
        }
        return newCp;
    }
    private static boolean isValidLocation(byte row, byte col, byte[][] maze) {
        return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length
                && (maze[row][col] == 0  || maze[row][col] == 5);
    }


    static void print(int[][] matrix)
    {
        // 打印矩阵
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                switch (matrix[i][j]) {
                    case 0:
                        System.out.print("⬜ ");
                        break;
                    case 1:
                        System.out.print("⬛ ");
                        break;
                   case 2:
                        System.out.print("🟩 ");
                        break;
                    case 3:
                        System.out.print("🟥 ");
                        break;
                    case 4:
                        System.out.print("🟦 ");
                        break;
                    case 5: // 起点和终点
                        System.out.print("🩷 ");
                        break;
                    default:
                        System.out.print("");
                        break;
                }
            }
            System.out.println(); // 换行
        }
        System.out.println("==============================="); // 换行
        System.out.println(); // 换行
    }

}

