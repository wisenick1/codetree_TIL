import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        // Please write your code here.

        int[] numofDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days1 = 0;
        int days2 = 0;

        for(int i = 0; i < m1 - 1; i++) {
            days1 += numofDays[i];
        }
        days1 += d1;

        for(int i = 0; i < m2 - 1; i++) {
            days2 += numofDays[i];
        }
        days2 += d2;

        System.out.println(days2 - days1 + 1);
    }
}