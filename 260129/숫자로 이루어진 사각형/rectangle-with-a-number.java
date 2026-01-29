import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        print(n);
    }

    private static void print(int x) {
        int num = 0;
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < x; j++) {
                if(++num % 10 == 0) {
                    num = 1;
                }
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}