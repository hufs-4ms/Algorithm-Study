import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // BufferedReader를 사용하여 입력값을 받음
        int[] arr = new int[n];  // 배열을 생성
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");  // StringTokenizer를 사용하여 중복을 제외한 정수들을 배열에 저장
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
                arr[i] = num;
            }
        }
        Arrays.sort(arr);  // 저장한 배열을 오름차순으로 정렬
        int k = n-map.size();
        int[] dp = new int[map.size()];
        for(int i=n-1;i>=k;i--){
            if(i == n-1){  // 중복을 제외한 정수들을 저장한 배열을 이용하여 연속된 숫자의 곱의 최댓값을 구함
                dp[i-k] = arr[i]*map.get(arr[i]);
            }else {
                boolean b = arr[i + 1] - arr[i] == 1;
                if(i == n-2){
                    if(b){
                        dp[i-k] = Math.max(arr[i]*map.get(arr[i]), dp[i-k+1]);
                    }else{
                        dp[i-k] = arr[i]*map.get(arr[i])+dp[i-k+1];
                    }
                }else{
                    if(b){
                        dp[i-k] = Math.max(arr[i]*map.get(arr[i])+dp[i-k+2], dp[i-k+1]);
                    }else{
                        dp[i-k] = arr[i]*map.get(arr[i])+dp[i-k+1];
                    }
                }
            }
        }
        System.out.print(dp[0]);  // 구한 최댓값을 출력
        br.close();
    }
}



// 정렬을 사용한 후에 count를 찾기 위해 한번의 for문을 돌렸기 때문에 시간복잡도는 O(nlogn)이다.
