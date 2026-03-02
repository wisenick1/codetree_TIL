import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer>[] list = new ArrayList[n + 1];
        int[] indegree = new int[n + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            indegree[b]++;
        }
        // Please write your code here.
        
        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) {
                pq.add(i);
            }
        }

        while(!pq.isEmpty()) {
            int poll = pq.poll();
            sb.append(poll).append(" ");

            for(int k : list[poll]) {
                indegree[k]--;
                if(indegree[k] == 0) {
                    pq.add(k);
                }
            }
        }

        System.out.println(sb);

    }
}