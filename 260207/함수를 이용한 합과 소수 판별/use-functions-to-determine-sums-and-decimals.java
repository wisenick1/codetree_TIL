import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        // Please write your code here.
        System.out.println(methodA(a, b));
    }

    private static int methodA(int a, int b) {
        int result = 0;
        for(int i = a; i <= b; i++) {
            if (!isSum(i)) continue;
            if (isPrime(i)) result++;
        }
        return result;
    }

    private static boolean isSum(int x) {
        int sum = 0;
        while(x / 10 != 0) {
            sum += x%10;
            x /= 10;
        }
        sum += x;
        if(sum % 2 == 0) return true;
        return false; 
    }

    private static boolean isPrime(int x) {
    if (x < 2) return false;
    for (int i = 2; i * i <= x; i++) {
        if (x % i == 0) return false;
    }
    return true;
}

}