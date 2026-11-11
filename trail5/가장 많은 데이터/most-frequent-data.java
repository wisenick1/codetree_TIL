import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        Map<String, Integer> map = new HashMap<>();

        int max = 0;
        for(int i = 0; i < n; i++) {
            int k = map.getOrDefault(arr[i], 0) + 1;
            max = Math.max(max, k);

            map.put(arr[i], k);
        }

        System.out.println(max);
    }
}