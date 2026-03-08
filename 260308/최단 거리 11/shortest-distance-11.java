import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int index;
        int dist;

        public Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.index, node.dist);
        }
    }

    static class Element implements Comparable<Element> {
        int index;
        int dist;

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
    static int a, b;
    static List<Node>[] graph;
    static int[] dist;
    static PriorityQueue<Element> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        init();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            graph[x].add(new Node(y, z));
            graph[y].add(new Node(x, z));
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        dijkstra();

        sb.append(dist[a]).append('\n');

        makePath();

        System.out.println(sb);
    }

    private static void init() {
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = (int)1e9;
        }
    }

    private static void dijkstra() {
        dist[b] = 0;
        pq.add(new Element(b, 0));

        while (!pq.isEmpty()) {
            Element e = pq.poll();
            int minIndex = e.index;
            int minDist = e.dist;

            if(dist[minIndex] != minDist) continue;

            for(Node node : graph[minIndex]) {
                int targetIndex = node.index;
                int targetDist = node.dist;

                int sumDist = targetDist + minDist;
                if(dist[targetIndex] > sumDist) {
                    dist[targetIndex] = sumDist;
                    pq.add(new Element(targetIndex, sumDist));
                }
            }
        }
    }

    private static void makePath() {
        int k = a;
        sb.append(k).append(" ");

        while (k != b) {
            for(Node node : graph[k]) {
                if(dist[node.index] + node.dist == dist[k]) {
                    k = node.index;
                    break;
                }
            }
            sb.append(k).append(" ");
        }
    }
}
