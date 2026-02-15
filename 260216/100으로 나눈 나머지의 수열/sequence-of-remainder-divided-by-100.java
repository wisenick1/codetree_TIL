import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        System.out.println(printN(n));
    }

    private static int printN(int n) {
        if(n == 1) return 2;
        else if(n == 2) return 4;

        return printN(n - 2) * printN(n - 1) % 100;
    }
}