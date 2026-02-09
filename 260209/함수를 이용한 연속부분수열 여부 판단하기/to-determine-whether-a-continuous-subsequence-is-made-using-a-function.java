import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] a = new int[n1];
        int[] b = new int[n2];
        for (int i = 0; i < n1; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < n2; i++)
            b[i] = sc.nextInt();
        // Please write your code here.

        if(check(a, b)) System.out.println("Yes");
        else System.out.println("No");
    }

    private static boolean check(int[] arr, int[] arr2) {
        int cnt = 0;
        
        if(arr.length < arr2.length) return false;

        for(int i = 0; i < arr.length - arr2.length; i++) {
            for(int j = 0; j < arr2.length; j++) {
                if(arr[i + j] == arr2[j]) cnt++;
            }
            if(cnt == arr2.length) return true;
            cnt = 0;
        }
        return false;
    }
}