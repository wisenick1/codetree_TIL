import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        System.out.println(square(n));
    }

    private static int square (int n) {
        if(n / 10 == 0) return (int)Math.pow(n , 2);

        return square(n / 10) + (int)Math.pow(n % 10, 2);
    }
}