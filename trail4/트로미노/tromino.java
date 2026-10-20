import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int max;
    static int[][] grid;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check();

        System.out.println(max);

    }

    private static void check() {
        max = 0;
        int sum = 0;

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                sum = 0;
                sum += grid[i][j];
                for(int k = 0; k <= 1; k++) {
                    sum += grid[i + dr[k]][j + dc[k]];
                }
                max = Math.max(max, sum);
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m - 1; j++) {
                sum = 0;
                sum += grid[i][j];
                for(int k = 1; k <= 2; k++) {
                    sum += grid[i + dr[k]][j + dc[k]];
                }
                max = Math.max(max, sum);
            }
        }

        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < m - 1; j++) {
                sum = 0;
                sum += grid[i][j];
                for(int k = 2; k <= 3; k++) {
                    sum += grid[i + dr[k]][j + dc[k]];
                }
                max = Math.max(max, sum);
            }
        }

        for(int i = 0; i < n - 1; i++) {
            for(int j = 1; j < m; j++) {
                sum = 0;
                sum += grid[i][j];
                for(int k = 3; k <= 4; k++) {
                    sum += grid[i + dr[k%4]][j + dc[k%4]];
                }
                max = Math.max(max, sum);
            }
        }

        for(int i = 1; i < n - 1; i++) {
            for(int j = 0; j < m; j++) {
                sum = 0;
                sum += grid[i][j];
                for(int k = 1; k <= 3; k += 2) {
                    sum += grid[i + dr[k]][j + dc[k]];
                }
                max = Math.max(max, sum);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 1; j < m - 1; j++) {
                sum = 0;
                sum += grid[i][j];
                for(int k = 2; k <= 4; k += 2) {
                    sum += grid[i + dr[k%4]][j + dc[k%4]];
                }
                max = Math.max(max, sum);
            }
        }
    }
}