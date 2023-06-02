import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        for(int i=1;i<n-1;i++){
            int j = i;
            int sum = 0;
            while(j>0){
                sum += arr[j];
                if(dp[j-1] > sum){
                    if(j-1 == 0){
                        dp[i] = dp[j-1] + sum;
                        break;
                    }else{
                        j--;
                    }
                }else{
                    dp[i] = sum;
                    break;
                }
            }
        }

        dp[n-1] = Integer.MAX_VALUE;
        int sum = 0;
        int num = n-1;
        while(num>0){
            sum += arr[num];
            int sum_t = Math.max(dp[num-1], sum);
            dp[n-1] = Math.min(dp[n-1], sum_t);
            num--;
        }


        System.out.print(dp[n-1]);
    }

}