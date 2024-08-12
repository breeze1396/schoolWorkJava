package test;

public class test {
    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder("abc");
        StringBuilder s2 = new StringBuilder("abc");

        System.out.println(s1.toString().equals(s2.toString()));
        System.out.println(s1==s2);
        String a = "sdas dasdd dada";
        String[] strs = a.split(" ");
        for(var c : strs)
        {
            System.out.println(c);
        }

    }
}
