import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        // Please write your code here.

        if(word1.length() != word2.length()) {
            System.out.println("No");
            return;
        }

        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        boolean isPossible = true;
        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) isPossible = false;
        }

        System.out.println(isPossible ? "Yes" : "No");
    }
}