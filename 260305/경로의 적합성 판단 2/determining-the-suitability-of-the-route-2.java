import java.util.*;
import java.io.*;

public class Main {
    static int n, m, k;
    static int[] parent;
    static int[] path;
    static boolean isSame = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        init();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            path[i] = Integer.parseInt(st.nextToken());
        }
        // Please write your code here.

        System.out.println(check() ? 1 : 0);

    }

    private static void init() {
        parent = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        path = new int[k];
    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        parent[y] = x;
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        int root = find(parent[x]);
        parent[x] = root;
        return root;
    }

    private static boolean check() {
        for (int i = 0; i < k - 1; i++) {
            if(find(path[i]) != find(path[i + 1])) return false;
        }
        return true;
    }


}