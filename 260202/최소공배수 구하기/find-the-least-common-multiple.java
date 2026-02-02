import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.
        method1(n, m);
    }

    private static void method1(int x, int y) {
        int min = Math.min(x, y);
        int result = 0;
        for(int i = 1; i <= min; i++) {
            if(x % i == 0 && y % i == 0) {
                result = i;
            }
        }
        System.out.println(result * (x / result) * (y / result));
    }
}