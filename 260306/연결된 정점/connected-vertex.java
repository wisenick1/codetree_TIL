import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] parent, size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        init();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            char input = st.nextToken().charAt(0);
            if(input == 'x') {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            } else {
                int a = Integer.parseInt(st.nextToken());
                sb.append(size[find(a)]).append('\n');
            }
        }

        System.out.println(sb);
    }

    private static void init() {
        parent = new int[n + 1];
        size = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if(x == y) return;

        if(size[x] < size[y]) {
            parent[x] = y;
            size[y] += size[x];
        } else {
            parent[y] = x;
            size[x] += size[y];
        }
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        int root = find(parent[x]);
        parent[x] = root;
        return root;
    }
}