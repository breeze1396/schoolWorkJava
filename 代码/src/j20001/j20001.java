package j20001;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// 岛屿数量

public class j20001  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

              /*int H = sc.nextInt();
        int W = sc.nextInt();

        int[][] grid = new int[H][W];

        for(int i = 0; i < H; ++i)
        {
            for (int j = 0; j < W; ++j)
            {
                grid[i][j] = sc.nextInt();
            }
        }*/

        int[][] grid = readMatrixFromFile();

        List<Integer> islandSizes = calculateIslandSizes(grid);
        for (int size : islandSizes) {
            System.out.print(size+" ");
        }

    }
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};


    // 方法用于从文件中读取矩阵数据
    public static int[][] readMatrixFromFile() {
        String fileName = "C:\\Users\\breeze\\OneDrive\\桌面\\java题\\20001.txt"; // 文件路径
        int rows = 112;
        int cols = 132;
        int[][] matrix = new int[rows][cols];
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null && row < rows) {
                String[] values = line.split(" "); // 假设数据之间以空格分隔
                for (int col = 0; col < Math.min(values.length, cols); col++) {
                    matrix[row][col] = Integer.parseInt(values[col]);
                }
                row++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null; // 或者抛出异常，取决于你的错误处理策略
        }
        return matrix;
    }
    public static List<Integer> calculateIslandSizes(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return new ArrayList<>();
        }

        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        List<Integer> islandSizes = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int size = dfs(grid, visited, i, j);
                    islandSizes.add(size);
                }
            }
        }

        return islandSizes;
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
