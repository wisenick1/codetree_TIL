import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        System.out.println(fac(n));
    }

    private static int fac(int n) {
        if(n == 0) return 1;

        return fac(n - 1) * n;
    }
}