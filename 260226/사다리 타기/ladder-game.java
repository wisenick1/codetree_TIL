import java.util.*;
public class Main {
    static int n, m;
    static List<Row> list; //가로줄 list
    static int[] arr; //세로줄 번호 - 바뀌는 거 저장
    static int[] arr2; //최초 정답 예시 -> 3, 4, 1, 2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        arr2 = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i + 1;
            arr2[i] = i + 1;
        }
        m = sc.nextInt();
        list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.add(new Row(a, a + 1, b));
        }

        Collections.sort(list);
        // Please write your code here.
        initialLadder();
        dfs(0);
        System.out.println(min);
    }

    static int min = 12;
    static int rowCnt = 0;
    private static void dfs(int cnt) {
        if(cnt == m) {
            if(check()) {
                min = Math.min(min, rowCnt);
            }
            return;
        }

        int x = list.get(cnt).i - 1;
        int y = list.get(cnt).j - 1;
        int temp = 0;

        temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
        rowCnt++;

        dfs(cnt + 1);

        temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
        rowCnt--;

        dfs(cnt + 1);
    }

    //최초 사다리 타기
    private static void initialLadder() {
        for(int k = 0; k < list.size(); k++) {
            int x = list.get(k).i - 1;
            int y = list.get(k).j - 1;
            int temp = 0;

            temp = arr2[x];
            arr2[x] = arr2[y];
            arr2[y] = temp;
        }
    }

    //결과 같은지 확인
    private static boolean check() {
        for(int i = 0; i < n; i++) {
            if(arr[i] != arr2[i]) return false;
        }
        return true;
    }

    static class Row implements Comparable<Row> {
        int i;  // 사다리 가로시작i
        int j;  // 사다리 가로 i+1
        int idx;  // 위에서 몇번째야 

        public Row(int i, int j, int idx) {
            this.i = i;
            this.j = j;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row row) {
            return Integer.compare(this.idx, row.idx);
        }
    }
}