import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int width;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> list = new ArrayList<>();

        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    width = 1;
                    dfs(i, j);
                    list.add(width);
                    count++;
                }
            }
        }

        System.out.println(count);
        Collections.sort(list);
        for(int k : list) {
            System.out.println(k);
        }

    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;
        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if(visited[nr][nc] || map[nr][nc] == 0) continue;
            width++;
            dfs(nr, nc);
        }
    }
}