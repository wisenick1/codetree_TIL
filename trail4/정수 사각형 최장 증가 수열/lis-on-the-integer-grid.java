import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] grid;
    static int[][] dp;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }

        System.out.println(ans);
         
    }

    private static int dfs(int r, int c) {
        if(dp[r][c] != 0) {
            return dp[r][c];
        }

        dp[r][c] = 1;

        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;

            if(grid[nr][nc] > grid[r][c]) {

                dp[r][c] = Math.max(
                    dp[r][c],
                    dfs(nr, nc) + 1
                );

            }

        }

        return dp[r][c];

    }
}