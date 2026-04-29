import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int result;
    static boolean[] visited;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        result = 0;

        for(int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            list[x].add(y);
            list[y].add(x);
        }

        visited[1] = true;
        dfs(1);

        System.out.println(result);
    }

    private static void dfs(int index) {
        int size = list[index].size();
        for(int i = 0; i < size; i++) {
            int cur = list[index].get(i);
            if(!visited[cur]) {
                visited[cur] = true;
                result++;
                dfs(cur);
            }
        }
    }
}