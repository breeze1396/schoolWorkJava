package j100xx;

import java.io.*;

import java.util.*;

interface IReadBook {
    public void ReadBook();
}
class CBauStu implements IReadBook{
    public void ReadBook() {
        System.out.println("本科生读教材");
    }
}
class CGduStu implements IReadBook{
    public void ReadBook() {
        System.out.println("硕士生读中文学术期刊");
    }
}
class CDocStu implements IReadBook{
    public void ReadBook() {
        System.out.println("博士生读外文学术期刊");
    }
}

class Test {
    public void DoRead(IReadBook reader) {
        reader.ReadBook();
    }
    public static void main(String[] args) {
        Test test = new Test();

        // 多态性演示
        System.out.println("本科生：");
        test.DoRead(new CBauStu());

        System.out.println("\n硕士生：");
        test.DoRead(new CGduStu());

        System.out.println("\n博士生：");
        test.DoRead(new CDocStu());
    }
}