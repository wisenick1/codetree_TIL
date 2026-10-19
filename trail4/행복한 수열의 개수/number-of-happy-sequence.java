import java.util.*;
import java.io.*;
  
public class Main {
    static int n;
    static int m;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if(m == 1) {
            System.out.println(2 * n);
            return;
        }

        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        check(grid);
        check2(grid);

        System.out.println(answer);
    }

    private static void check(int[][] grid) {
        for(int i = 0; i < n; i++) {
            int value = 0;  //비교값
            int cnt = 1;    //같은 개수
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == value) {
                    cnt++;
                    if(cnt >= m) {
                        answer++;
                        break;
                    }
                } else {
                    value = grid[i][j];
                    cnt = 1;
                }
            }
        }
    }

    private static void check2(int[][] grid) {
        for(int i = 0; i < n; i++) {
            int value = 0;  //비교값
            int cnt = 1;    //같은 개수
            for(int j = 0; j < n; j++) {
                if(grid[j][i] == value) {
                    cnt++;
                    if(cnt >= m) {
                        answer++;
                        break;
                    }
                } else {
                    value = grid[j][i];
                    cnt = 1;
                }
            }
        }
    }
}