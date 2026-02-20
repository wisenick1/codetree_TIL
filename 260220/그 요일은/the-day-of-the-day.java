import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String A = sc.next();
        // Please write your code here.

        int[] daysofMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dow = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int[] cnt = new int[7];

        int days1 = 0, days2 = 0;

        for(int i = 0; i < m1 - 1; i++) {
            days1 += daysofMonth[i];
        }
        days1 += d1;

        for(int i = 0; i < m2 - 1; i++) {
            days2 += daysofMonth[i];
        }
        days2 += d2;

        int diff1 = (days2 - days1) / 7;
        for(int i = 0; i < 7; i++) {
            cnt[i] = diff1;
        }
        int diff2 = (days2 - days1) % 7 + 1;
        for(int i = 0; i < diff2; i++) {
            cnt[i]++;
        }

        int idx = 0;
        for(int i = 0; i < 7; i++) {
            if(A.equals(dow[i])) idx = i;
        }

        System.out.println(cnt[idx]);
    }
}