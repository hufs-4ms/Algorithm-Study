// 땅따먹기
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, K, answer = 0;
    static int[][] arr, temp;
    static boolean[][] pick;
    public static void solution(int x, int y, int select, int value){
        if(select == K){
           answer = Math.max(answer, value);
           return;
        }
        if(select < K && x >= N){
            return;
        }
        // 다음 좌표
        int nx = x, ny = y + 3;
        if(ny >= N-2){
            nx += 1;
            ny = 0;
        }

        // 선택
        pick[x][y] = true;
        solution(nx, ny, select+1, value+temp[x][y]);
        pick[x][y] = false;

        // 다음 좌표
        nx = x;
        ny = y + 1;
        if(ny >= N-2){
            nx += 1;
            ny = 0;
        }
        // 선택하지 않고 넘어감
        solution(nx, ny, select, value);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        temp = new int[N][N-2];
        pick = new boolean[N][N-2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N-2; j++){
                temp[i][j] = arr[i][j] + arr[i][j+1] + arr[i][j+2];
            }
        }
        
        solution(0, 0, 0, 0);

        if(answer == 0)
            System.out.println(-1);
        else
            System.out.println(answer);
    }
}

// DP
//import java.io.*;
//import java.util.*;
//public class Main {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        st = new StringTokenizer(br.readLine(), " ");
//        int n = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//        int[][] arr = new int[n][n];
//        int[][][] dp = new int[n+1][n+1][k+1];
//        for(int i=0;i<n;i++){
//            st = new StringTokenizer(br.readLine(), " ");
//            for(int j=0;j<n;j++){
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        int result = 0;
//
//        if(k > n*n/3){
//            result = -1;
//            System.out.print(result);
//            System.exit(0);
//        }
//        for(int l=1;l<=k;l++){
//            for(int i=1;i<=n;i++){
//                for(int j=3;j<=n;j++){
//                    if((i-1)*n/3 + j/3 < l){
//                        continue;
//                    }
//                    if(i>1 && j==3){
//                        dp[i][j][l] = Math.max(dp[i-1][n][l], dp[i-1][n][l-1] + arr[i-1][j-1] + arr[i-1][j-2] + arr[i-1][j-3]);
//                    }else if(i>1 && j<6){
//                        dp[i][j][l] = Math.max(dp[i][j-1][l], dp[i-1][n][l-1] + arr[i-1][j-1] + arr[i-1][j-2] + arr[i-1][j-3]);
//                    }else{
//                        dp[i][j][l] = Math.max(dp[i][j-1][l], dp[i][j-3][l-1] + arr[i-1][j-1] + arr[i-1][j-2] + arr[i-1][j-3]);
//                    }
//                }
//            }
//        }
//        result = dp[n][n][k];
//
//        for(int i=0;i<k;i++){
//            if (result < dp[n][n][i + 1]) {
//                result = 0;
//                break;
//            }
//        }
//
//        if(result == 0){
//            System.out.print(-1);
//        }else{
//            System.out.println(result);
//        }
//    }
//}
//
