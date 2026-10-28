import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] grid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }    
        }
        
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int val = grid[r - 1][c - 1];

        bomb(val - 1, r - 1, c - 1);
        move();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void bomb(int val, int r, int c) {
        for(int i = r - val; i <= r + val ; i++) {
            if(i < 0) continue;
            if(i >= n) break;
            grid[i][c] = 0;
        }

        for(int j = c - val; j <= c + val ; j++) {
            if(j < 0) continue;
            if(j >= n) break;
            grid[r][j] = 0;
        }
    }

    private static void move() {
        for(int i = 0; i < n; i++) {
            int[] temp = new int[n];
            int idx = n - 1;
            for(int j = n - 1; j >= 0; j--) {
                if(grid[j][i] > 0) {
                    temp[idx--] = grid[j][i];
                }
            }

            for(int j = n - 1; j >= 0; j--) {
                grid[j][i] = temp[j];
            }
        }
    }
}