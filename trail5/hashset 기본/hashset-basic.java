import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int x = Integer.parseInt(st.nextToken());

            if(command.equals("find")) {
                if(set.contains(x)) sb.append("true").append('\n');
                else sb.append("false").append('\n');
            }

            if(command.equals("add")) {
                set.add(x);
            }

            if(command.equals("remove")) {
                set.remove(x);
            }

        }

        System.out.println(sb);
    }
}