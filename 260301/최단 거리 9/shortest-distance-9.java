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
        List<Node>[] graph = new ArrayList[n + 1];
        PriorityQueue<Element> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        int[] path = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }
        int a = sc.nextInt();
        int b = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            dist[i] = (int)1e9;
        }

        dist[a] = 0;
        pq.add(new Element(dist[a], a));

        while(!pq.isEmpty()) {
            Element e = pq.poll();
            int minDist = e.dist;
            int minIndex = e.index;

            if(dist[minIndex] != minDist) continue;

            for(int i = 1; i < graph[minIndex].size(); i++){
                int targetIndex = graph[minIndex].get(i).index;
                int targetDist = graph[minIndex].get(i).dist;

                int sumDist = minDist + targetDist;
                if(dist[targetIndex] > sumDist) {
                    dist[targetIndex] = sumDist;
                    pq.add(new Element(sumDist, targetIndex));
                    path[targetIndex] = minIndex;
                }
            }
        }

        System.out.println(dist[b]);
        List<Integer> list = new ArrayList<>();
        int k = b;
        list.add(b);
        while(k != a) {
            k = path[k];
            list.add(k);
        }
        for(int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }

    }
}