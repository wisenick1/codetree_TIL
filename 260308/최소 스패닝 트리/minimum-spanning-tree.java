import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int x;
        int y;
        int dist;

        public Edge(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.dist, e.dist);
        }
    }

    static int n, m;
    static int[] parent;
    static List<Edge> edges;
    static int cost;
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
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, c));
        }

        mst();

        System.out.println(cost);
        
    }

    private static void init() {
        parent = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        edges = new ArrayList<>();
        cost = 0;
    }

    private static void union(Edge e) {
        int x = find(e.x);
        int y = find(e.y);

        if(x == y) return;

        parent[y] = x;
        cost += e.dist;
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        int root = find(parent[x]);
        parent[x] = root;
        return root;
    }

    private static void mst() {
        Collections.sort(edges);

        for(Edge e : edges) {
            union(e);
        }
    }
}