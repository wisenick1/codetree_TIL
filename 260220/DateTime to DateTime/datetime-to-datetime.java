import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        // Please write your code here.

        int minutes1 = 10 * 24 * 60 + 11 * 60 + 11;
        int minutes2 = (A - 1) * 24 * 60 + B * 60 + C;

        if(minutes2 < minutes1) System.out.println(-1);
        else System.out.println(minutes2 - minutes1);
    }
}