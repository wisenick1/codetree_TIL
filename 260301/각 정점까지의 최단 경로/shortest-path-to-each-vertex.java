import java.util.*;

public class Main {
    static class Node {
        int index;
        int dist;

        public Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }
    }

    static class Element implements Comparable<Element> {
        int dist;
        int index;

        public Element(int dist, int index) {
            this.dist = dist;
            this.index = index;
        }

        @Override
        public int compareTo(Element e) {
            return Integer.compare(this.dist, e.dist);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        List<Node>[] graph = new ArrayList[n + 1];
        PriorityQueue<Element> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }
        
        for(int i = 1; i <= n; i++) {
            dist[i] = (int)1e9;
        }

        dist[k] = 0;

        pq.add(new Element(dist[k], k));

        while(!pq.isEmpty()) {
            Element e = pq.poll();
            int minDist = e.dist;
            int minIndex = e.index;

            if(minDist != dist[minIndex]) continue;
            
            for(int i = 0; i < graph[minIndex].size(); i++) {
                int targetIndex = graph[minIndex].get(i).index;
                int targetDist = graph[minIndex].get(i).dist;
                int sumDist = minDist + targetDist;
                if(dist[targetIndex] > sumDist) {
                    dist[targetIndex] = sumDist;
                    pq.add(new Element(sumDist, targetIndex));
                }
            }

        }

        for(int i = 1; i <= n; i++) {
            if(dist[i] == (int)1e9) sb.append(-1).append('\n');
            else sb.append(dist[i]).append('\n');
        }

        System.out.println(sb);
    }
}