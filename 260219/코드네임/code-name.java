import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Please write your code here.
        Agent[] arr = new Agent[5];
        for(int i = 0; i < 5; i++) {
            String codeName = sc.next();
            int score = sc.nextInt();
            arr[i] = new Agent(codeName, score);
        }

        int idx = 0;
        int min = 101;
        for(int i = 0; i < 5; i++) {
            if(arr[i].score < min) {
                idx = i;
                min = arr[i].score;
            }
        }

        System.out.println(arr[idx].codeName + " " + arr[idx].score);


    }
}

class Agent {
    String codeName;
    int score;

    public Agent(String codeName, int score) {
        this.codeName = codeName;
        this.score = score;
    }
}