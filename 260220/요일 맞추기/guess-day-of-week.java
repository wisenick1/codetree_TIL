import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        // Please write your code here.

        int[] daysofMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dow = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        int days1 = 0, days2 = 0;

        for(int i = 0; i < m1 - 1; i++) {
            days1 += daysofMonth[i];
        }
        days1 += d1;

        for(int i = 0; i < m2 - 1; i++) {
            days2 += daysofMonth[i];
        }
        days2 += d2;

        int diff = (days1 - days2) % 7;

        if(diff < 0) {
            int a = Math.abs(diff);
            System.out.println(dow[a]);
        } else {
            System.out.println(dow[(7 - diff) % 7]);
        }
    }
}