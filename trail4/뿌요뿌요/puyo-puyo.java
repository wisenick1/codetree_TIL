import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int count;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        int max = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    count = 1;
                    dfs(i, j); 
                    if(count >= 4) result++;   
                    max = Math.max(max, count);
                }
            }
        }

        System.out.println(result + " " + max);

    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;
        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if(map[nr][nc] != map[r][c] || visited[nr][nc]) continue;

            count++;
            dfs(nr, nc);
        }
    }
}