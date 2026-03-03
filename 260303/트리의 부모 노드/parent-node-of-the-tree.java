import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];  //0, 1 안씀
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for(int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= n; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(int j) {
        visited[j] = true;

        for(int k : list[j]) {
            if(!visited[k]){
                visited[k] = true;
                parent[k] = j;
                dfs(k);
            }
        }
    }
}