import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String com = st.nextToken();

            if(com.equals("add")) {
                int key = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());
                map.put(key, val);
            }

            if(com.equals("remove")) {
                int key = Integer.parseInt(st.nextToken());
                map.remove(key);
            }

            if(com.equals("find")) {
                int key = Integer.parseInt(st.nextToken());
                if(map.containsKey(key)) {
                    sb.append(map.get(key)).append('\n');
                } else {
                    sb.append("None").append('\n');
                }
            }
        }

        System.out.println(sb);

    }
}