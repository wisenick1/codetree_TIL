import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] indegree = new int[n + 1];
        List<Integer>[] list = new ArrayList[n + 1];
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            indegree[b]++;
        }
        
        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()) {
            int poll = q.poll();

            for(int i = 0; i < list[poll].size(); i++) {
                int k = list[poll].get(i);
                indegree[k]--;
                if(indegree[k] == 0) {
                    q.add(k);
                }
            }
            sb.append(poll).append(" ");
        }

        System.out.println(sb);
    }
}