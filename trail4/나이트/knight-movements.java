import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int r2, c2;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken()) - 1;
        int c1 = Integer.parseInt(st.nextToken()) - 1;
        r2 = Integer.parseInt(st.nextToken()) - 1;
        c2 = Integer.parseInt(st.nextToken()) - 1;

        map = new int[N][N];
        visited = new boolean[N][N];

        bfs(r1, c1);
        System.out.println(visited[r2][c2] != false ? map[r2][c2] : -1);
    }

    private static void bfs(int r, int c) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{r, c});
        visited[r][c] = true;

        while(!deque.isEmpty()) {
            int[] poll = deque.poll();
            int curR = poll[0];
            int curC = poll[1];

            for(int i = 0; i < 8; i++) {
                int nr = curR + dr[i];
                int nc = curC + dc[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if(visited[nr][nc]) continue;

                map[nr][nc] = map[curR][curC] + 1;
                deque.add(new int[] {nr, nc});
                visited[nr][nc] = true;
                if(nr == r2 && nc == c2) return;
            }
        }
    }
}