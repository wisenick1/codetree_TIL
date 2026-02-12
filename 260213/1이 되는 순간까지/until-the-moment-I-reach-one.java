import java.util.Scanner;
public class Main {
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        cntNum(n);
    }

    private static void cntNum(int n) {
        if(n == 1) {
            System.out.println(cnt);
            return;
        }

        if(n % 2 == 0) {
            cnt++;
            cntNum(n / 2);
        } else {
            cnt++;
            cntNum(n / 3);
        }

    }
}