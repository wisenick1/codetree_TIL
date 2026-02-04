import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        System.out.println(isYear(y));
    }

    private static boolean isYear(int y) {
        if(y % 100 == 0) {
            if(y % 400 != 0) return false;
            return true;
        }

        if(y % 4 == 0) return true;
        
        return false;
    }
}