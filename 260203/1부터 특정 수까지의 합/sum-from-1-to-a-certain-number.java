import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        System.out.println(add(n)/10);
    }

    private static int add(int x) {
        int sum = 0;
        for(int i = 1; i <= x; i++) {
            sum += i;
        }
        return sum;
    }
}