import java.util.Scanner;
// 岛屿数量

public class j20001edn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();

        int[][] grid = new int[H][W];

        for(int i = 0; i < H; ++i)
        {
            for (int j = 0; j < W; ++j)
            {
                grid[i][j] = sc.nextInt();
            }
        }

        calculateIslandSizes(grid);
        System.out.printf(answer.toString());
    }
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private static StringBuilder answer = new StringBuilder();

    // 方法用于从文件中读取矩阵数据
    public static void calculateIslandSizes(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return;
        }

        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int size = dfs(grid, visited, i, j);
                    //System.out.printf("%d", size);
                    answer.append(size).append(" ");
                }
            }
        }
    }

    private static int dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;
        int size = 1;

        for (int[] direction : DIRECTIONS) {
            int newRow = i + direction[0];
            int newCol = j + direction[1];
            size += dfs(grid, visited, newRow, newCol);
        }

        return size;
    }
}
