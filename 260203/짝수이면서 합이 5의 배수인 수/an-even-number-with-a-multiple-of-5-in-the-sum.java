import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        if(isMagicNum(n)) System.out.println("Yes");
        else System.out.println("No");
    }

    private static boolean isMagicNum (int x) {
        if((x / 10 + x % 10) % 5 == 0 && x % 2 == 0) return true;
        return false;
    }
}