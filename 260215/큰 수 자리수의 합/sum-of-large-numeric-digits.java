import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        // Please write your code here.

        System.out.println(sumEach(a * b * c));
    }

    private static int sumEach(int n) {
        if(n < 10) return n;

        return sumEach(n / 10) + n % 10;
    }
}