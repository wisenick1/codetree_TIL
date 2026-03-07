import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] parent;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        init();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v);
        }
        
        connect();

        System.out.println(cnt);

    }

    private static void init() {
        parent = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if(x == y) {
            cnt++;
            return;
        }
        parent[y] = x;
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        int root = find(parent[x]);
        parent[x] = root;
        return root;
    }

    private static void connect() {
        int a = find(1);
        for(int i = 1; i <= n; i++) {
            if(find(i) != a) {
                cnt++;
                union(a, i);
            }
        }
    }

}