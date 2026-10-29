import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] grid;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        grid = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.print(grid[r][c] + " ");
        move(r, c);

    }

    private static void move(int r, int c) {
        while(true) {
            boolean isPossible = false;

            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr <= 0 || nc <= 0 || nr > n || nc > n) continue;
                
                if(grid[nr][nc] > grid[r][c]) {
                    r = nr;
                    c = nc;
                    isPossible = true;
                    break;
                }
                
            }
            
            if(!isPossible) break;
            System.out.print(grid[r][c] + " ");
        }

        

    }
}