import java.util.*;
import java.io.*;


public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int qType = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(qType == 0) union(a, b);
            else System.out.println(find(a) == find(b) ? 1 : 0);
        }
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return;

        if(x <= y) parent[y] = x;
        else parent[x] = y;
        return;

    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
}