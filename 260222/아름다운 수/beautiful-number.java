import java.util.Scanner;
public class Main {
    static int len;
    static int result;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        len = n;
        dfs(0);
        System.out.println(result);
    }

    
    private static void dfs(int cnt) {
        if(cnt == len) {
            result++;
            return;
        }

        if(cnt > len) return;

        for(int i = 1; i < 4; i++) {
            dfs(cnt + i);
        }
    }
}