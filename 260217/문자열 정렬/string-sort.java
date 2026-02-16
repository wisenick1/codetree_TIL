import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        // Please write your code here.
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String str = new String(arr);
        System.out.println(str);
    }
}