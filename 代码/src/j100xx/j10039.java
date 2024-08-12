package j100xx;

import java.util.Scanner;

public class j10039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[][] Student = new String[N][6];
        for(int i = 0;i < N;i++)
        {
            int sum =0;
            for(int j = 0;j < 4;j++)
            {
                Student[i][j] = sc.next();
            }
            sum = Integer.parseInt(Student[i][1]) + Integer.parseInt(Student[i][2]) + Integer.parseInt(Student[i][3]);
            Student[i][4] = "" + sum;
            Student[i][5] = "" + i;
        }
        //排序
        for(int i = 0;i < N -1;i++)
        {
            for(int j = N -1;j > i;j--)
            {
                if(Integer.parseInt(Student[i][4]) < Integer.parseInt(Student[j][4]))
                {
                    String[] tempArr = Student[i];
                    Student[i] = Student[j];
                    Student[j] = tempArr;
                }else if(Integer.parseInt(Student[i][4]) == Integer.parseInt(Student[j][4]))
                {
                    if(Integer.parseInt(Student[i][5]) > Integer.parseInt(Student[j][5]))
                    {
                        String[] tempArr = Student[i];
                        Student[i] = Student[j];
                        Student[j] = tempArr;
                    }
                }
            }
        }
        for(int i = 0;i < N;i++)
        {
            for(int j = 0;j < 5;j++)
            {
                System.out.print(Student[i][j] + " ");
            }
            System.out.println();
        }
    }
}