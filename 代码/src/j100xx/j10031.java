package j100xx;

import java.io.*;
import java.util.*;
class Student{
    String Name;//姓名
    double NGrade;//平时成绩
    double EGrade;//考试成绩
    public Student(String Name, double NGrade, double EGrade){
        super();
        this.Name = Name;
        this.NGrade = NGrade;
        this.EGrade = EGrade;
    }

    public Student() {

    }

    public String getName() {
        return this.Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public double getNGrade() {
        return NGrade;
    }
    public void setNGrade(double NGrade) {
        this.NGrade = NGrade;
    }
    public double getEGrade() {
        return EGrade;
    }
    public double sumGrade() {
        return this.NGrade * 0.3 + this.EGrade * 0.7;
    }

    /* 比较总分，如果as总分更高则输出1, 相等输出0，否则输出-1; */
    public int CompareTS(Student s) {
        return Double.compare(this.sumGrade(), s.sumGrade());
    }

    public String toString() {
        return String.format(
                "姓名:%s\n平时成绩:%.1f\n考试成绩:%.1f\n总成绩:%.1f",
                Name,NGrade,EGrade,sumGrade());
    }

    public void setEGrade(double v) {
        EGrade = v;
    }
}



public class j10031 {

    public static void main(String[] args) {
/* 构造函数参数按顺序为:姓名，平时成绩，考试成绩 */
        Student as = new Student("小明", 80.0, 90.0);
        Student bs = new Student("小芳", 85.0, 95.0);

        System.out.println(as.getNGrade()); // 输出平时成绩
        System.out.println(as.getEGrade()); // 输出考试成绩
        System.out.println(as.getName());   // 输出姓名
        System.out.println(as.sumGrade());  // 输出总成绩
        as.setName("晓明"); // 修改姓名
        as.setNGrade(90.5); // 修改平时成绩
        as.setEGrade(85.0); // 修改考试成绩
/* 比较总分，如果as总分更高则输出1, 相等输出0，否则输出-1; */
        System.out.println(as.CompareTS(bs));
        System.out.println(as.toString());
    }


}
