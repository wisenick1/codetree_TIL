import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] words = new String[n + 1];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String word = br.readLine();
            words[i] = word;
            map.put(word, i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            String query = br.readLine();

            if (Character.isDigit(query.charAt(0))) {
                sb.append(words[Integer.parseInt(query)]);
            } else {
                sb.append(map.get(query));
            }

            sb.append('\n');
        }

        System.out.print(sb);
    }
}