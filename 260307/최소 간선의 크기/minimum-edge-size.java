import java.io.*;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(e.w, this.w);
        }
    }

    static int n, m;
    static int a, b;
    static int[] parent;
    static List<Edge> edges = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        init();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            edges.add(new Edge(u, v, s));
        }

        mst();  

        System.out.println(sb);
    }

    static void init() {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        int root = find(parent[x]);
        parent[x] = root;
        return root;
    }

    static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if(x == y) return;
        
        parent[y] = x;
    }

    static void mst() {
        Collections.sort(edges);

        for (Edge e : edges) {
            union(e.u, e.v);

            if (find(a) == find(b)) {
                sb.append(e.w);
                return;
            }
        }
    }
}