import java.util.Scanner;

public class j20007 {
    public static void main(String[] args) {
            f();
    }
    static void f()
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1) {
            System.out.println(0);
            return;
        }

        int c= 0;
        int parted = 0;
        while (true)
        {
            if(n < 2) break;
            if( n % 3 == 0) {
                parted = n / 3;
                n = parted+1;
            }
            else {
                parted = n / 3 + 1;
                n = parted;
            }

            c++;
        }
        System.out.println(c);
    }

}