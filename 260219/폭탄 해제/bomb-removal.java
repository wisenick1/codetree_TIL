import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String uCode = sc.next();
        char lColor = sc.next().charAt(0);
        int time = sc.nextInt();
        // Please write your code here.
        Bomb bomb = new Bomb(uCode, lColor, time);
        System.out.println("code : " + bomb.code);
        System.out.println("color : " + bomb.color);
        System.out.println("second : " + bomb.second);
    }
}

class Bomb {
    String code;
    char color;
    int second;

    public Bomb(String code, char color, int second) {
        this.code = code;
        this.color = color;
        this.second = second;
    }
}