import java.util.Scanner;

public class Main {
    static int k, n;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        // Please write your code here.
        arr = new int[n];
        makeNum(0);
    }

    private static void makeNum(int cnt) {
        if(cnt == n) {
            for(int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= k; i++) {
            arr[cnt] = i;
            makeNum(cnt + 1);
        }

    }
}