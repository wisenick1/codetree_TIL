import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] parent;
    static int[][] edges;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        init();
        for (int i = 0; i < n - 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            union(edges[i][0], edges[i][1]);
        }

        connect();
        
        for(int k : set) {
            System.out.print(k + " ");
        }
    }

    private static void init() {
        parent = new int[n + 1];
        edges = new int[n - 2][2];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if(x == y) return;
        if(x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        int root = find(parent[x]);
        parent[x] = root;
        return root;
    }

    private static void connect() {
        for(int i = 1; i <= n; i++) {
            set.add(find(i));
        }
    }
}