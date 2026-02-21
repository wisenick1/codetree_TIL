import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            // Please write your code here.
            switch(command) {
                case "push_front":
                int a = sc.nextInt();
                list.addFirst(a);
                break;
                case "push_back":
                a = sc.nextInt();
                list.add(a);
                break;
                case "pop_front":
                System.out.println(list.poll());
                break;
                case "pop_back":
                System.out.println(list.pollLast());
                break;
                case "size":
                System.out.println(list.size());
                break;
                case "empty":
                System.out.println(list.isEmpty() ? 1 : 0);
                break;
                case "front":
                System.out.println(list.peek());
                break;
                case "back":
                System.out.println(list.peekLast());
                break;

            }
        }
    }
}