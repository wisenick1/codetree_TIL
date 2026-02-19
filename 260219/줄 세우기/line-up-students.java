import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        int[] weight = new int[n];
        Student[] arr = new Student[n];
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
            weight[i] = sc.nextInt();
            arr[i] = new Student(height[i], weight[i], i + 1);
        }
        // Please write your code here.
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i].h + " " + arr[i].w + " " + arr[i].n);
        }
    }
}

class Student implements Comparable<Student> {
    int h;
    int w;
    int n;

    public Student(int h, int w, int n) {
        this.h = h;
        this.w = w;
        this.n = n;
    }

    @Override
    public int compareTo(Student s) {
        if(this.h == s.h && this.w == s.w) return this.n - s.n;
        if(this.h == s.h) return s.w - this.w;
        return s.h - this.h;
    }
}