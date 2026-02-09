import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int d = sc.nextInt();
        // Please write your code here.
        if(isPossible(m, d)) System.out.println("Yes");
        else System.out.println("No");
    }

    private static boolean isPossible(int m, int d) {
        if(m > 12) return false; 
        else {
            switch(m) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                if(d <= 31) return true;
                case 4: case 6: case 9: case 11:
                if(d <= 30) return true;
                case 2:
                if(d <= 28) return true;
                default:
                return false;
            }
        }
    }
}