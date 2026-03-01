import java.util.*;
public class Main {
    static class Node{
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

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();
            graph[b].add(new Node(a, d));
        }
        
        for (int i = 1; i <= n; i++) {
            dist[i] = (int)1e9;
        }

        dist[n] = 0;

        pq.add(new Element(0, n));

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

        Arrays.sort(dist);

        System.out.println(dist[n]);
    }
}