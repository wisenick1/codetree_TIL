import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String str = sc.next();
            switch (str) {
                case "push_back":
                int a = sc.nextInt();
                list.add(a);
                break;
                case "pop_back":
                list.remove(list.size() - 1);
                break;
                case "size":
                System.out.println(list.size());
                break;
                case "get":
                int k = sc.nextInt();
                System.out.println(list.get(k - 1));
            }
        }
    }
}