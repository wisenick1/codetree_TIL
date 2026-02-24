import java.util.Scanner;
import java.util.*;

public class Main {
    static List<int[]> list = new ArrayList<>();
    static int n;
    static int[][] segments;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
            list.add(new int[]{segments[i][0], segments[i][1]});
        }
        // Please write your code here.

        dfs(0);
        System.out.println(result);
        
    }

    static boolean[] visited = new boolean[1001];
    static int max = 0;
    static int result = 0;
    private static void dfs(int cnt) {
        if(cnt == n) {
            result = Math.max(max, result);
            return;
        }

        int x = list.get(cnt)[0];
        int y = list.get(cnt)[1];
        boolean isPossible = true;
        for(int i = x; i <= y; i++) {
            if(visited[i]) {
                isPossible = false;
                break;
            }
        }

        if(!isPossible) dfs(cnt + 1);
        else {
            for(int i = x; i <= y; i++) {
                visited[i] = true;
            }
            max++;
            dfs(cnt + 1);
            max--;
            for(int i = x; i <= y; i++) {
                visited[i] = false;
            }
        }
    }
}