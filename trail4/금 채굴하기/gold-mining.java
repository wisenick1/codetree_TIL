import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int max;
    static int[][] grid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        cal();
        System.out.println(max);

    }

    private static void cal() {
        int gold = 0;
        int price = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k <= n + 1; k++) {
                    gold = check(i, j, k);
                    if(m * gold >= k*k + (k+1)*(k+1)) {
                        max = Math.max(max, gold);
                    }
                }
            }
        }
    }


    private static int check(int r, int c, int k) {
        int gold = 0;
        for(int i = r - k; i <= r + k; i++) {
            int dist = Math.abs(i - r);
            int width = k - dist;
            for(int j = c - width; j <= c + width; j++) {
                if(i < 0 || i >= n || j < 0 || j >= n) continue;
                if(grid[i][j] == 1) gold++;
            }
        }
        return gold;
    }
}