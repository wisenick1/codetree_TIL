import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = sc.nextInt();
        }
        // Please write your code here.
        Arrays.sort(nums);

        Integer[] nums2 = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(nums2, Collections.reverseOrder());

        int max = 0;
        for(int i = 0; i < n; i++) {
            if(max < nums[i] + nums2[i]) max = nums[i] + nums2[i];
        }

        System.out.println(max);
    }
}