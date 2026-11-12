import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] words = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            words[i] = sc.next();
        }
        String[] queries = new String[m];
        for (int i = 0; i < m; i++) {
            queries[i] = sc.next();
        }

        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();

        for(int i = 1; i <= n; i++) {
            map1.put(words[i], i);
            map2.put(i, words[i]);
        }

        for(int i = 0; i < m; i++) {
            if(Character.isDigit(queries[i].charAt(0))) {
                System.out.println(map2.get(Integer.valueOf(queries[i])));
            } else {
                System.out.println(map1.get(queries[i]));
            }
        }

    }
}