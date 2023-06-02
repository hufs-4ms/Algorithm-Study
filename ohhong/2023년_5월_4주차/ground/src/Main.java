import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        int[][][] dp = new int[n+1][n+1][k+1];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

//        if(k > n*n/3){
//            result = -1;
//            System.out.print(result);
//            System.exit(0);
//        }
        for(int l=1;l<=k;l++){
            for(int i=1;i<=n;i++){
                for(int j=3;j<=n;j++){
                    if((i-1)*n/3 + j/3 < l){
                        continue;
                    }
                    if(i>1 && j==3){
                        dp[i][j][l] = Math.max(dp[i-1][n][l], dp[i-1][n][l-1] + arr[i-1][j-1] + arr[i-1][j-2] + arr[i-1][j-3]);
                    }else if(i>1 && j<6){
                        dp[i][j][l] = Math.max(dp[i][j-1][l], dp[i-1][n][l-1] + arr[i-1][j-1] + arr[i-1][j-2] + arr[i-1][j-3]);
                    }else{
                        dp[i][j][l] = Math.max(dp[i][j-1][l], dp[i][j-3][l-1] + arr[i-1][j-1] + arr[i-1][j-2] + arr[i-1][j-3]);
                    }
                }
            }
        }
        result = dp[n][n][k];

        for(int i=0;i<k;i++){
            if (result < dp[n][n][i + 1]) {
                result = 0;
                break;
            }
        }

        if(result == 0){
            System.out.print(-1);
        }else{
            System.out.println(result);
        }
    }
}

