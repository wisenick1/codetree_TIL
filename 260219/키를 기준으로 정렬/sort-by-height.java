import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        Person[] arr = new Person[n];
        for(int i = 0; i < n; i++) {
            String name = sc.next();
            int height = sc.nextInt();
            int weight = sc.nextInt();
            arr[i] = new Person(name, height, weight);
        }

        Arrays.sort(arr, (a, b) -> a.height - b.height);

        for(int i = 0; i < n; i++) {
            System.out.println(arr[i].name + " " + arr[i].height + " " + arr[i].weight);
        }
    }


}

class Person {
    String name;
    int height;
    int weight;

    public Person(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }
}