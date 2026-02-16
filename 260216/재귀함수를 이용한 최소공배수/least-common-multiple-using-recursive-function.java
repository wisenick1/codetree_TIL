import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        System.out.println(LCM(n - 1, arr));
    }

    private static int LCM(int n, int[] arr) {
        if(n == -1) return 1;

        int prior = LCM(n - 1, arr);
        int min = 0;
        if(prior < arr[n]) min = prior;
        else min = arr[n];

        int GCD = 1;
        for(int i = 1; i <= min; i++) {
            if(prior % i == 0 && arr[n] %i == 0) GCD = i;
        }
        
        return (prior / GCD) * (arr[n] / GCD) * GCD;
    }
}