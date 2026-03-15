import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] graph;
    static int[] indegree;
    static int n, m;
    static StringBuilder sb = new StringBuilder();
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
            graph[a].add(b);
            indegree[b]++;
        }

        topologysort();

        System.out.println(sb);

    }

    private static void init() {
        graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        indegree = new int[n + 1];
    }

    private static void topologysort() {
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int poll = queue.poll();
            sb.append(poll).append(" ");

            for(int k : graph[poll]) {
                indegree[k]--;

                if(indegree[k] == 0) {
                    queue.add(k);
                }
            }
        }
    }
}