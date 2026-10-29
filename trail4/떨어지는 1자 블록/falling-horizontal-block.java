import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int r = 0;
        boolean isblocked = false;
        for(int i = 0; i < n; i++) {
            if(isblocked) break;
            for(int j = k - 1; j < k + m - 1; j++) {
                if(!isblocked && grid[i][j] != 0) {
                    isblocked = true;
                    r = i - 1;
                    break;
                }
            }
        }

        if(!isblocked) {
            for(int i = k - 1; i < k + m - 1; i++) {
                grid[n - 1][i] = 1;
            }
        } else {
            for(int i = k - 1; i < k + m - 1; i++) {
                grid[r][i] = 1;
            }
        }
        

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}