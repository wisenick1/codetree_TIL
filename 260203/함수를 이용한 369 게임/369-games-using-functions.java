import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        // Please write your code here.
        int cnt = 0;
        for(int i = A; i <= B; i++) {
            if(isMagicNum(i)) cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean isMagicNum(int x) {
        return x % 3 == 0 || isNum3(x);
    }

    private static boolean isNum3(int k) {
        boolean isIn = false;
        String str = "" + k;
        if(str.contains("3") || str.contains("6") || str.contains("9")) isIn = true;
        return isIn;
    }
}