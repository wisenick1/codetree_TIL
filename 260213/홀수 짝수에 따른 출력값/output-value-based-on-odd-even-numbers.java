import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        System.out.println(sumN(n));
    }

    private static int sumN(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        return sumN(n - 2) + n;
    }
}