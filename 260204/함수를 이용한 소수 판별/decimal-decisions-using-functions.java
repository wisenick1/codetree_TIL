import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        // Please write your code here.
        int result = 0;
        for(int i = a; i <= b; i++) {
            if(isPrime(i)){
                result += i;
            }    
        }
        System.out.println(result);
    }

    private static boolean isPrime(int x) {
        for(int i = 2; i < x; i++) {
            if(x % i == 0) return false;
        }
        return true;
    }
}