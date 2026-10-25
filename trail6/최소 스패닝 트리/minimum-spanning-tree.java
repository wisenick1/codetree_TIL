import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int dist;

        public Edge(int u, int v, int dist) {
            this.u = u;
            this.v = v;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.dist, e.dist);
        }

    }

    static List<Edge> edges;
    static int[] parent;
    static int cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        parent = new int[n + 1];
        cost = 0;

        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, cost));
        }

        mst();

        System.out.println(cost);

    }

    static void union(Edge e) {
        int x = find(e.u);
        int y = find(e.v);

        if(x == y) return;

        if(x < y) parent[y] = x;
        else parent[x] = y;

        cost += e.dist;
    }

    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void mst() {
        Collections.sort(edges);

        for(Edge e : edges) {
            union(e);
        }
    }
}