import java.util.*;
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
    static int max;  //최댓값
    static int cnt;  //그 때 마다 간선의 합
    static int idx;  //최댓값의 idx
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        list = new ArrayList[n + 1];

        for(int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        int x = 0;
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            list[u].add(new Node(v, w));
            list[v].add(new Node(u, w));
            x = u;
        }
        // Please write your code here.
        max = 0;
        cnt = 0;
        visited = new boolean[n + 1];
        dfs(x);

        visited = new boolean[n + 1];
        cnt = 0;
        max = 0;
        dfs(idx);
        
        System.out.println(max);

    }

    static void dfs(int i) {
        visited[i] = true;
        for(Node node: list[i]) {
            if(!visited[node.index]) {
                visited[node.index] = true;
                cnt += node.value;
                if(cnt > max) {
                    max = cnt;
                    idx = node.index;
                }
                dfs(node.index);
                cnt -= node.value;
            }
        }    
        
    }
}