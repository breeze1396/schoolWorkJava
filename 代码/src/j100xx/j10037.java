package j100xx;

import java.io.*;

import java.util.*;

interface ICry{
    void Cry();
}
class CFrog implements ICry{
    public void Cry() {
        System.out.println("青蛙哇哇叫");
    }
}
class CDog implements ICry{
    public void Cry() {
        System.out.println("小狗汪汪叫");
    }
}
class CCat implements ICry{
    public void Cry() {
        System.out.println("小猫喵喵叫");
    }
}