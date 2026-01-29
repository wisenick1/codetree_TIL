public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        for(int i = 0; i < 5; i++) {
            printStars();
            System.out.println();
        }
    }

    private static void printStars() {
        for(int i = 0; i < 10; i++) {
            System.out.print("*");
        }
    }
}