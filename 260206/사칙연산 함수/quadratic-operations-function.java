import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        char o = sc.next().charAt(0);
        int c = sc.nextInt();
        // Please write your code here.
        switch(o) {
            case '+':
            sum(a, c);
                break;
            case '-':
            minus(a, c);
                break;
            case '*':
            multi(a, c);
                break;
            case '/':
            divide(a, c);
                break;
            default:
                System.out.println("False");
                break;

        }
    }

    private static void sum(int a, int c) {
        System.out.println(a + " " + "+" + " " + c + " " + "=" + " " + (a+c));
    }

    private static void minus(int a, int c) {
        System.out.println(a + " " + "-" + " " + c + " " + "=" + " " + (a-c));
    }

    private static void multi(int a, int c) {
        System.out.println(a + " " + "*" + " " + c + " " + "=" + " " + (a*c));
    }

    private static void divide(int a, int c) {
        System.out.println(a + " " + "/" + " " + c + " " + "=" + " " + (a/c));
    }
}