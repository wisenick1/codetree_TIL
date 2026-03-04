import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    static List<Node>[] list;
    static boolean[] visited;
    static int max;
    static int maxIdx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        max = 0;

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        maxIdx = 1;
        dfs(1, 0);

        visited = new boolean[n + 1];
        max = 0;
        dfs(maxIdx, 0);

        System.out.println(max);
    }

    private static void dfs(int i, int dist) {
        visited[i] = true;
        if(dist > max) {
            max = dist;
            maxIdx = i;
        }

        for(Node node : list[i]) {
            if(!visited[node.index]) {
                dfs(node.index, dist + node.value);
            }
        }
    }
}
