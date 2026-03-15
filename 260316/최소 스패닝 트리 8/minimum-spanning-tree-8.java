import java.util.*;
import java.io.*;

public class Main {
    static class Edge {
        int v, w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static class Element implements Comparable<Element> {
        int v, w;

        public Element(int v, int w) {
            this.v = v;
            this.w = w;
        }

        public int compareTo(Element e) {
            return Integer.compare(this.w, e.w);
        }
    }

    static List<Edge>[] graph;
    static int n, m;
    static PriorityQueue<Element> pq;
    static int result;
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
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        prim();

        System.out.println(result);
    }

    private static void init() {
        graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        pq = new PriorityQueue<>();
        result = 0;
    }

    private static void prim() {
        boolean[] visited = new boolean[n + 1];
        pq.add(new Element(1, 0));
        int count = 0;

        while(!pq.isEmpty()) {
            Element e = pq.poll();
            int minIndex = e.v;
            int minDist = e.w;

            if(visited[minIndex]) continue;

            count++;
            visited[minIndex] = true;
            result += minDist;

            for(Edge edge : graph[minIndex]) {
                int targetIndex = edge.v;
                int targetDist = edge.w;

                if(!visited[targetIndex]) {
                    pq.add(new Element(targetIndex, targetDist));
                }
            }

            if(count == n) return;
        }
        
    }

}