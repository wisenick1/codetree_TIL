import java.util.*;
public class Main {
    static int maxCnt = 0;
    static List<int[]> locBomb;
    static int n;
    static int[][] grid;
    static int[][] count;
    static int[] dx1 = {1, 2, -1, -2};
    static int[] dy1 = {0, 0, 0, 0};
    static int[] dx2 = {0, 0, 1, -1};
    static int[] dy2 = {1, -1, 0, 0};
    static int[] dx3 = {-1, 1, 1, -1};
    static int[] dy3 = {1, 1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        count = new int[n][n];
        locBomb = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 1) {
                    locBomb.add(new int[]{i, j});
                }
            }
        }
        // Please write your code here.
        dfs(0);
        System.out.println(maxCnt);
    }

    private static void dfs(int idx) {
        if(idx == locBomb.size()) {
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == 1 || count[i][j] > 0) {
                        cnt++;
                    }
                }
            }
            maxCnt = Math.max(cnt, maxCnt);
            return;
        }

        int curX = locBomb.get(idx)[0];
        int curY = locBomb.get(idx)[1];

        for(int i = 0; i < 4; i++) {
            int x = curX + dx1[i];
            int y = curY + dy1[i];
            if(x < 0 || y < 0 || x >= n || y >= n) continue;
            count[x][y]++;
        }
        dfs(idx + 1);
        for(int i = 0; i < 4; i++) {
            int x = curX + dx1[i];
            int y = curY + dy1[i];
            if(x < 0 || y < 0 || x >= n || y >= n) continue;
            count[x][y]--;
        }

        for(int i = 0; i < 4; i++) {
            int x = curX + dx2[i];
            int y = curY + dy2[i];
            if(x < 0 || y < 0 || x >= n || y >= n) continue;
            count[x][y]++;
        }
        dfs(idx + 1);
        for(int i = 0; i < 4; i++) {
            int x = curX + dx2[i];
            int y = curY + dy2[i];
            if(x < 0 || y < 0 || x >= n || y >= n) continue;
            count[x][y]--;
        }

        for(int i = 0; i < 4; i++) {
            int x = curX + dx3[i];
            int y = curY + dy3[i];
            if(x < 0 || y < 0 || x >= n || y >= n) continue;
            count[x][y]++;
        }
        dfs(idx + 1);
        for(int i = 0; i < 4; i++) {
            int x = curX + dx3[i];
            int y = curY + dy3[i];
            if(x < 0 || y < 0 || x >= n || y >= n) continue;
            count[x][y]--;
        }
        
    }
}