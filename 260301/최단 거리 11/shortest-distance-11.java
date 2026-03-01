import java.util.*;
public class Main {
    static class Node implements Comparable<Node> {
        int index;
        int dist;
        public Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node n) {
            return Integer.compare(this.index, n.index);
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
        List<Node>[] graph = new ArrayList[n + 1];
        PriorityQueue<Element> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            graph[x].add(new Node(y, z));
            graph[y].add(new Node(x, z));
        }
        int a = sc.nextInt();
        int b = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }
        
        for(int i = 1; i <= n; i++) {
            dist[i] = (int)1e9;
        }

        dist[b] = 0;

        pq.add(new Element(0, b));

        while(!pq.isEmpty()) {
            Element e = pq.poll();
            int minDist = e.dist;
            int minIndex = e.index;

            if(dist[minIndex] != minDist) continue;

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

        sb.append(dist[a]).append('\n');
        sb.append(a).append(" ");
        int x = a;

        while(x != b) {
            for(Node no : graph[x]) {
                int nIndex = no.index;
                int nDist = no.dist;

                if(nDist + dist[nIndex] == dist[x]) {
                    x = nIndex;
                    break;
                }
            }
            sb.append(x).append(" ");
        }

        System.out.println(sb);
    }
}