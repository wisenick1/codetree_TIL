import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sCode;
        char mPoint;
        int time;
        // Please write your code here.
        sCode = sc.next();
        mPoint = sc.next().charAt(0);
        time = sc.nextInt();

        System.out.println("secret code : " + sCode);
        System.out.println("meeting point : " + mPoint);
        System.out.println("time : " + time);
    }
}