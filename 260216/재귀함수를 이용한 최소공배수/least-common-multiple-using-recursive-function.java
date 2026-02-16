import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        System.out.println(LCM(n - 1, arr));
    }

    private static int LCM(int n, int[] arr) {
        if(n == -1) return 1;

        return LCM(n - 1, arr) * arr[n] / GCD(LCM(n - 1, arr), arr[n]);
    }

    private static int GCD(int a, int b) {
        if(b == 0) return a;

        return GCD(b, a % b);
    }
}