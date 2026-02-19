import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] arr = new Student[n];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score1 = sc.nextInt();
            int score2 = sc.nextInt();
            int score3 = sc.nextInt();
            arr[i] = new Student(name, score1, score2, score3);
        }
        // Please write your code here.
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i].name + " " + arr[i].s1 + " " + arr[i].s2 + " " + arr[i].s3);
        }
    }
}

class Student implements Comparable<Student> {
    String name;
    int s1;
    int s2;
    int s3;

    public Student(String name, int s1, int s2, int s3) {
        this.name = name;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    public int compareTo(Student s) {
        return (this.s1 + this.s2 + this.s3) - (s.s1 + s.s2 + s.s3);
    }
}