import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        // Please write your code here.

        char[] arr = binary.toCharArray();

        double ans = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '1') {
                ans += Math.pow(2, arr.length - i - 1);
            }
        }

        System.out.println((int)ans);
    }
}