import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static boolean[][] visited;
    static int[][] map;
    static int[] dr = {0, 1};
    static int[] dc = {1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(visited[N - 1][M - 1] ? 1 : 0);
    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;
        for(int i = 0; i < 2; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr >= N || nc >= M) continue;
            if(map[nr][nc] == 0 || visited[nr][nc]) continue;

            dfs(nr, nc);
        }
    }
}