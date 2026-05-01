import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int resultK = 1;
        int maxSafeZones = 0;

        for (int k = 1; k <= maxHeight; k++) {
            visited = new boolean[N][M];
            int currentSafeZones = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && map[i][j] > k) {
                        dfs(i, j, k);
                        currentSafeZones++;
                    }
                }
            }

            if (currentSafeZones > maxSafeZones) {
                maxSafeZones = currentSafeZones;
                resultK = k;
            }
        }

        if (maxSafeZones == 0) {
            System.out.println("1 0");
        } else {
            System.out.println(resultK + " " + maxSafeZones);
        }
    }

    private static void dfs(int r, int c, int k) {
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
                if (!visited[nr][nc] && map[nr][nc] > k) {
                    dfs(nr, nc, k);
                }
            }
        }
    }
}