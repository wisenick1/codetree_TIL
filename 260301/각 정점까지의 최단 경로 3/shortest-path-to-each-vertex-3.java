import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n + 1][n + 1];
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u][v] = w;
        }
        // Please write your code here.
        int[] result = new int[n - 1];
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++) {
            dist[i] = 1000000;
        }

        dist[1] = 0;
        int idx = 0;
        for(int i = 1; i < n; i++) {
            int minIndex = -1;

            //제일 작은 dist index 뽑기
            for(int j = 1; j <= n; j++) {
                if(visited[j]) continue;

                if(minIndex == -1 || dist[minIndex] > dist[j]) {
                    minIndex = j;
                }
            }

            visited[minIndex] = true;
            //dist 값 갱신
            for(int j = 1; j <= n; j++) {
                if(graph[minIndex][j] == 0) continue;
                dist[j] = Math.min(dist[j], dist[minIndex] + graph[minIndex][j]);
            }
        }

        for(int i = 2; i <= n; i++) {
            if(dist[i] == 1000000) {
                sb.append(-1).append('\n');
            } else {
                sb.append(dist[i]).append('\n');
            }
        }

        System.out.println(sb);
    }
}