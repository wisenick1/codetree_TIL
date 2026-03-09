import java.util.*;
import java.io.*;

public class Main {
    static class Edge {
        int index, dist;

        public Edge(int index, int dist){
            this.index = index;
            this.dist = dist;
        }
    }

    static class Element implements Comparable<Element> {
        int index, dist;

        public Element(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Element e) {
            return Integer.compare(this.dist, e.dist);
        }
    }

    static int n, m;
    static int[] dist;
    static List<Edge>[] graph;
    static PriorityQueue<Element> pq;
    static int result;
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
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        prim();
        
        System.out.println(result);
    }

    private static void init() {
        dist = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            dist[i] = (int)1e9;
        }

        pq = new PriorityQueue<>();
        graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        result = 0;
    }

    private static void prim() {
        dist[1] = 0;
        pq.add(new Element(1, 0));

        while(!pq.isEmpty()) {
            Element e = pq.poll();
            int minIndex = e.index;
            int minDist = e.dist;

            if(minDist > dist[minIndex]) continue;

            result += minDist;

            for(Edge edge : graph[minIndex]) {
                int targetIndex = edge.index;
                int targetDist = edge.dist;

                if(targetDist < dist[targetIndex]) {
                    dist[targetIndex] = targetDist;
                    pq.add(new Element(targetIndex, targetDist));
                }
            }
        }
    }

}