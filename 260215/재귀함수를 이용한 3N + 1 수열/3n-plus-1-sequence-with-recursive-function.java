import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        System.out.println(makeOne(n, 0));
    }

    private static int makeOne(int n, int cnt) {
        if(n == 1) return cnt;

        cnt++;
        if(n % 2 == 0) return makeOne(n / 2, cnt);
        else return makeOne(n * 3 + 1, cnt);
    }
}