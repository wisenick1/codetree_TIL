import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        System.out.println(maxNum(0, n, arr, 0));
    }

    private static int maxNum(int cnt, int n, int[] arr, int max) {
        if(cnt == n){
            return max;
        }

        if(arr[cnt] > max) {
            max = arr[cnt];
        }
        return maxNum(cnt + 1, n, arr, max);
    }
}