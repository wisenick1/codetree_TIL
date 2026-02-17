import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String t = sc.next();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        // Please write your code here.

        List<String> list = new LinkedList<>();
        for(String s : words) {
            if(s.startsWith(t)) list.add(s);
        }

        Collections.sort(list);
        System.out.println(list.get(k - 1));
    }
}