import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.w, e.w);
        }
    }

    static int n, m;
    static List<Edge> edges = new ArrayList<>();
    static int[] parent;
    static char[] types;
    static int cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        init();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            types[i] = st.nextToken().charAt(0);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, c));
        }

        mst();

        System.out.println(cost);
        
    }

    private static void init() {
        edges = new ArrayList<>();
        parent = new int[n + 1];
        types = new char[n + 1];
        cost = 0;
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    private static void union(Edge e){
        int x = find(e.u);
        int y = find(e.v);

        if(types[e.u] == types[e.v]) return;
        if(x == y) return;
    
        parent[y] = x;
        cost += e.w;
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

        for(int i = 2; i <= n; i++) {
            if(find(1) != find(i)) {
                System.out.println(-1);
                System.exit(0);
            }
        }
    }
}