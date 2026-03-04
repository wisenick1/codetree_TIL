import java.util.Scanner;
public class Main {
    static int[] parent;
    static int[] rank;
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        init();

        for (int i = 0; i < m; i++) {
            int qType = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            calculate(qType, a, b);
        }
    }

    private static void init() {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    private static void calculate(int qType, int a, int b) {
        switch(qType) {
            case 0:
                union(a, b);
                break;
            case 1:
                System.out.println(find(a)==find(b) ? 1: 0);
        }
    }

    // private static void union(int a, int b) {
    //     int x = find(a);
    //     int y = find(b);
    //     if(x == y) return;

    //     parent[y] = x;
    // }

    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if(x == y) return;

        if(rank[x] < rank[y]) {
            parent[x] = y;
        } else {
            parent[y] = x;
            if(rank[x] == rank[y]) rank[x]++;
        }
        
    }

    private static int find(int k) {
        if(parent[k] == k) return k;
        int root = find(parent[k]);
        parent[k] = root;
        return root;
    }
}