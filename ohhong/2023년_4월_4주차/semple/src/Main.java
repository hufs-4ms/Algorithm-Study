import java.util.*;
import java.io.*;
public class Main {
    static int[] arr;  // 사용된 index를 표시
    static int[] tree;  // tree를 만들어서 누적 합을 저장
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        tree = new int[4000004];
        int[] s = new int[n];  // 결과를 저장할 배열 A를 생성
        int[] l = new int[n];
        int sum;

        for(int i=0;i<n;i++){
            sum = query(arr[i]-1);
            s[i] = sum;
            update(arr[i]);
        }

        Arrays.fill(tree, 0);

        for(int i=n-1;i>=0;i--){
            sum = (n-i-1) - query(arr[i]);
            l[i] = sum;
            update(arr[i]);
        }

        // 값을 출력
        System.out.println(Arrays.toString(s));
        System.out.print(Arrays.toString(l));
        br.close();
    }
    public static void update(int index){  // i번째 수를 1만큼 더하는 함수
        index++;
        while(index < tree.length){
            tree[index] += 1;
            index += (index & -index);
        }
    }
    public static int query(int index){  // i번째 수까지의 누적 합을 계산하는 함수
        index++;
        int sum = 0;
        while(index > 0){
            sum += tree[index];
            index -= (index & -index);
        }
        return sum;
    }
}


// 이 알고리즘은 binary indexed tree를 사용하고 있다 배열 B를 뒤에서 부터 한번씩 확인하므로 O(n), 확인하면서 binary indexed tree를 검색하며, update를 하고 있으므로 O(log n)이된다. 그러므로 시간복잡도는 O(n*log n)가 된다.
