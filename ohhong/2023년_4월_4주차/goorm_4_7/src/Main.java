import java.util.*;
import java.io.*;
public class Main {
    static int[] arr;  // 사용된 index를 표시
    static int[] tree;  // tree를 만들어서 누적 합을 저장
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> B = new ArrayList<>();
        while(st.hasMoreTokens()){
            B.add(Integer.parseInt(st.nextToken()));
        }

        int n = B.size();  // 보든 배열들을 배열 B에 맞춰 길이를 조정
        arr = new int[n];
        tree = new int[getTreeSize(n)];
        int[] A = new int[n];  // 결과를 저장할 배열 A를 생성
        int sum;

        for(int i=n-1;i>=0;i--){  // 앞쪽에서 계산을 하게 되면 매번 값을 업데이트 해줘야 함으로 뒤에서 부터 값을 채워 넣는다
            int index = B.get(i);  // A[0]부터 A[i-1]까지 A[i]보다 작은 수의 개수를 받는다. 이 수는 arr의 i번째 수와 같다
            sum = query(index);  // 배열 arr의 arr[0]부터 arr[i-1]까지 값이 들어와 있는 원소의 개수
            A[i] = index;  // 우선 값을 넣고 sum의 값에 따라 순서를 결정한다
            while(sum != 0){  // sum이 0이 아니라는 뜻은 앖에 값이 이미 들어와 있다는 것을 뜻하므로 그 값만큼 증가시킨다.
                A[i] += sum;
                index += sum;
                if(query(index)==sum){  // 증가시키는 동안 또 값이 증가하지 않았다면 반복문을 종료시킨다.
                    break;
                }
                sum = query(index) - query(index-sum);  // 증가시키는 동안 값이 증가하였다면 증가하는 동안 값이 들어있는 원소가 있다는 뜻이므로 다시한번 증가시킨다.
            }
            arr[A[i]] = 1;  // 위 조건을 거친 index값을 표시한다.
            update(A[i]);  // tree에 값을 update시킨다.
        }
        StringBuilder sb = new StringBuilder();  // 값을 출력
        sb.append("[");
        for(int i=0;i<n-1;i++){
            sb.append(A[i]).append(", ");
        }
        sb.append(A[n-1]).append("]");
        System.out.print(sb);
        br.close();
    }
    public static int getTreeSize(int n) {  // Tree 사이즈를 계산하여 저장
        return (int) Math.pow(2, Math.ceil(Math.log(n) / Math.log(2))) + 1;
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
