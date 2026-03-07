import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;
    static int n, m;
    static int idx = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        init();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            idx++;
            union(a, b);
        }
        
        System.out.println("happy");
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
            System.out.println(idx);
            System.exit(0);
        }

        parent[y] = x;
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        int root = find(parent[x]);
        parent[x] = root;
        return root;
    }
}