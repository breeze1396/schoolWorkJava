package j100xx;

import java.io.*;
import java.util.*;
class CUser {
    String userName;
    String passWord;
    public CUser(String u,String p) {
        this.userName = u;
        this.passWord = p;
    }

    public CUser(CUser rc1) {
        this.userName = rc1.userName;
        this.passWord = rc1.passWord;
    }

    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String u) {
        this.userName = u;
    }
    public String getPassWord() {
        return this.passWord;
    }
    public void setPassWord(String p) {
        this.passWord = p;
    }
    public String Login(String InUserName,String InPassWord) {
        if(userName.equals(InUserName) && passWord.equals(InPassWord))
            return "登录成功";
        else
            return "登录失败";
    }
    public String toString()
    {
        return "userName:"+userName+"\n" +
                "passWord:"+passWord;
    }
}

/*
public class j10035 {
    public static void main(String[] args) {
        */
/* 构造函数参数按顺序为:userName, passWord *//*

        CUser rc1 = new CUser("刘德华", "isthecreatur123");
        CUser rc2 = new CUser(rc1);

        System.out.println(rc1.getUserName());
        System.out.println(rc1.getPassWord());

        rc2.setUserName("刘德化");
        rc2.setPassWord("coursecreator56");

        System.out.println(rc1.Login("刘德化", "isthecreatur56"));
        System.out.println(rc2.toString());


    }
}*/
