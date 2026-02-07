import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Please write your code here.
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.println(completeNum(A, B));
    }

    private static int completeNum(int a, int b) {
        int cnt = b - a + 1;
        for(int i = a; i <= b; i++) {
            if((i%2 == 0 || i%10 == 5 || divide3(i))) cnt -= 1;
        }
        return cnt;
    }

    private static boolean divide3(int x) {
        if(x % 3 == 0 && x % 9 != 0) return true;
        return false;
    }
}