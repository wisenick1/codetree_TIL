import java.util.Scanner;
public class Main {
    static int result;
    static int[] arr;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // Please write your code here.
        dfs(0);
        System.out.println(result);
    }

    
    private static void dfs(int cnt) {
        if(cnt == n) {
            result++;
            return;
        }

        if(cnt > n) return;

        for(int i = 1; i <= 4; i++) {
            dfs(cnt + i);
        }
    }
}