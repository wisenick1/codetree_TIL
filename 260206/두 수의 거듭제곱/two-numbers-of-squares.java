import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        // Please write your code here.
        int result = multi(a, b);
        System.out.println(result);
    }

    private static int multi(int a, int b) {
        int num = a;
        while (--b > 0) {
            a *= num;
        }
        return a;
    }
}