import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer>[] list = new ArrayList[n + 1];
        int[] indegree = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;

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
                queue.add(i);
                cnt++;
            }
        }

        while(!queue.isEmpty()) {
            int poll = queue.poll();

            for(int k : list[poll]) {
                indegree[k]--;
                if(indegree[k] == 0) {
                    queue.add(k);
                    cnt++;
                }
            }
        }

        if(cnt == n) {
            System.out.println("Consistent");
        } else {
            System.out.println("Inconsistent");
        }
    } 
}