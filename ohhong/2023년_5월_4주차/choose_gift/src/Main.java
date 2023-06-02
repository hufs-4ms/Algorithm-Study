import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] values = new int[n];
        int[] prices = new int[n];
        int[] difference = new int[n];
        MaxNumberSet set = new MaxNumberSet();
        Queue<Integer> insert = new LinkedList<>();
        Queue<Integer> delete = new LinkedList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            values[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            prices[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(values);  // value 값을 입력받은 후 정렬한다.
        Arrays.sort(prices);  // price 값을 입력받은 후 정렬한다. 정렬하면서 O(nlogn)의 시간이 소요된다.

        int max_difference = Integer.MIN_VALUE;
        int max_index = 0;

        for(int i=0;i<n;i++){  // 둘의 차이를 비교하면서 차이가 가장 큰 값의 개수를 구한다.
            difference[i] = Math.abs(values[i] - prices[i]);
            if(difference[i] > max_difference){  // difference는 value와 price의 차이를 저장한다.
                max_difference = difference[i];
                max_index = i;
            }
            set.insert(difference[i]);
        }
        int max_value = Integer.MAX_VALUE;
        int max_value_index = 0;
        int[] right_dp = new int[n];  // value값을 한개를 뺏을 때 남아있는 price는 오른쪽의 value와 비교하거나 왼쪽의 value와 비교를 한다.
        int[] left_dp = new int[n];  // 각 경우를 생각하기 위해서 2가지의 방향으로 진행되는 dp배열을 생성

        for(int i=n-2;i>=0;i--){  // i번째 value값을 뺏을 때 남아있는 price가 왼쪽의 value와 비교하여 기존의 차이 difference와 비교한다.
            if(Math.abs(values[i+1] - prices[i]) <= Math.abs(difference[i+1])){  // 기존의 difference보다 남아있는 price와 왼쪽의 value의 차이가 더 작으면 dp에 빠지는 수를 저장한다.

                if(left_dp[i+1] == 0){
                    set.remove(difference[i+1]);
                    insert.add(difference[i+1]);
                }
                set.insert(values[i+1] - prices[i]);
                delete.add(values[i+1] - prices[i]);
                set.remove(difference[i]);
                left_dp[i] = set.getMaxNumber();
            }else{
                while(!delete.isEmpty()){
                    set.remove(delete.poll());
                }
                while(!insert.isEmpty()){
                    set.insert(insert.poll());
                }
            }
            if(left_dp[i] < max_value){
                max_value = left_dp[i];
                max_value_index = i;
            }
        }  // O(n)만큼 걸린다.

        while(!delete.isEmpty()){
            set.remove(delete.poll());
        }
        while(!insert.isEmpty()){
            set.insert(insert.poll());
        }

        for(int i=1;i<n;i++){  // i번째 value값을 뺏을 때 남앙있는 price가 오른쪽의 value와 비교하여 기존의 차이 difference와 비교한다.
            if(Math.abs(values[i-1] - prices[i]) <= Math.abs(values[i-1] - prices[i-1])){  // 위와 똑같은 방식으로 계산한다.

                if(right_dp[i-1] == 0){
                    set.remove(difference[i-1]);
                    insert.add(difference[i-1]);
                }
                set.insert(values[i-1] - prices[i]);
                delete.add(values[i-1] - prices[i]);
                set.remove(difference[i]);
                right_dp[i] = set.getMaxNumber();
            }else{
                while(!delete.isEmpty()){
                    set.remove(delete.poll());
                }
                while(!insert.isEmpty()){
                    set.insert(insert.poll());
                }
            }
            if(right_dp[i] >= max_value){
                max_value = right_dp[i];
                max_value_index = i;
            }
        }

        int result = 0;
        if(max_difference <= max_value){
            result = max_index;
        }else{
            result = max_value_index;
        }

        System.out.println(Arrays.toString(difference));
        System.out.println(Arrays.toString(left_dp));
        System.out.println(Arrays.toString(right_dp));
        System.out.print(values[result]);
    }  // O(n)만큼 걸린다.
}

// 최종적으로 T(2*n*log n + 2*n)임으로 O(n*log n)의 시간복잡도를 가진다.
// 미완...
// 이 코드는 value와 price의 차이가 최대인 부분을 줄여주긴 하지만 최대인 부분을 최소로 줄여주지 못한다...


class MaxNumberSet {
    private List<Integer> numberList;

    public MaxNumberSet() {
        numberList = new ArrayList<>();
    }

    public void insert(int num) {
        numberList.add(num);
    }

    public void remove(int num) {
        numberList.remove(Integer.valueOf(num));
    }

    public int getMaxNumber() {
        return Collections.max(numberList);
    }
}