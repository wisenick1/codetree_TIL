import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int level = sc.nextInt();
        // Please write your code here.
        User user1 = new User();
        User user2 = new User(id, level);

        System.out.println("user" + " " + user1.id + " " + "lv" + " " + user1.level);
        System.out.println("user" + " " + user2.id + " " + "lv" + " " + user2.level);
    }
}

class User {
    String id = "codetree";
    int level = 10;

    public User() {}

    public User(String id, int level) {
        this.id = id;
        this.level = level;
    }
}