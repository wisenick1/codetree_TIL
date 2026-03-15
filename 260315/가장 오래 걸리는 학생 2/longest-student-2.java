import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int index, dist;

        public Node(int index, int dist) {
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
    static List<Node>[] graph;
    static PriorityQueue<Element> pq;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        init();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[b].add(new Node(a, d));
        }

        dijkstra();

        System.out.println(max());
    }

    private static void init() {
        graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        pq = new PriorityQueue<>();
        dist = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            dist[i] = (int)1e9;
        }
    }

    private static void dijkstra() {
        dist[n] = 0;
        pq.add(new Element(n, 0));

        while(!pq.isEmpty()) {
            Element e = pq.poll();
            int minIndex = e.index;
            int minDist = e.dist;

            if(minDist != dist[minIndex]) continue;

            for(Node node : graph[minIndex]) {
                int targetIndex = node.index;
                int targetDist = node.dist;

                int sumDist = minDist + targetDist;
                if(dist[targetIndex] > sumDist) {
                    dist[targetIndex] = sumDist;
                    pq.add(new Element(targetIndex, sumDist));
                }
            }
        }

    }

    private static int max() {
        int max = 0;

        for(int i = 1; i <= n; i++) {
            if(dist[i] != (int)1e9) max = Math.max(max, dist[i]);
        }
        return max;
    }
}