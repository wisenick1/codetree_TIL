import java.util.*;
import java.io.*;

public class Main {
    static int N, K, M;
    static int[][] grid;
    static int[][] removedgrid;
    static boolean[][] visited;
    static int[][] start;
    static int result;
    static List<int[]> stones;
    static List<int[]> choosed;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        removedgrid = new int[N][N];
        stones = new ArrayList<>();
        result = 0;
        choosed = new ArrayList<>();
        start = new int[K][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] == 1) stones.add(new int[]{i, j});
            }
        }

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            start[i][0] = Integer.parseInt(st.nextToken()) - 1;
            start[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        selectStones(0, 0);

        System.out.println(result);
    }

    private static void selectStones(int cnt, int idx) {
        if(cnt == M) {
            for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    removedgrid[i][j] = grid[i][j];
                }
            }

            for(int i = 0; i < choosed.size(); i++) {
                removedgrid[choosed.get(i)[0]][choosed.get(i)[1]] = 0;
            }

            visited = new boolean[N][N];
            for(int i = 0; i < start.length; i++) {
                bfs(start[i][0], start[i][1]);
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(removedgrid[i][j] == 2) count++;
                }
            }
            result = Math.max(result, count);
            return;
        }

        for(int i = idx; i < stones.size(); i++) {
            choosed.add(stones.get(i));
            selectStones(cnt + 1, i + 1);
            choosed.remove(choosed.size() - 1);
        }
    }

    private static void bfs(int r, int c) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{r, c});
        removedgrid[r][c] = 2;
        visited[r][c] = true;

        while(!deque.isEmpty()) {
            int[] poll = deque.poll();
            int curR = poll[0];
            int curC = poll[1];

            for(int i = 0; i < 4; i++) {
                int nr = curR + dr[i];
                int nc = curC + dc[i];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if(visited[nr][nc] || removedgrid[nr][nc] == 1) continue;

                deque.add(new int[]{nr, nc});
                visited[nr][nc] = true;
                removedgrid[nr][nc] = 2;
            }
        }
    }
}