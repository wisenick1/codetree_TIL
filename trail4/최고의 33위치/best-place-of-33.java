import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;

        for(int i = 1; i < n - 1; i++) {
            for(int j = 1; j < n - 1; j++) {
                max = Math.max(max, check(grid, i, j));       
            }
        }

        System.out.println(max);
    }

    private static int check(int[][] grid, int r, int c) {
        int cnt = 0;
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                if(grid[r + i][c + j] == 1) cnt++;
            }
        }
        return cnt;
    }
}