import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;
public class Main {
    static int n, m, k;
    static char[][] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        String str;
        int value;
        for(int i=0;i<n;i++){
            str = br.readLine();
            for(int j=0;j<m;j++){
                board[i][j] = str.charAt(j);
            }
        }
        bw.write(Math.min(chess('B'),chess('W'))+"");
        br.close();
        bw.flush();
        bw.close();
    }
    public static int chess(char color){
        int count = Integer.MAX_VALUE;
        int value;
        int [][]dp = new int[n+1][m+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i+j)%2 == 0){
                    value = board[i][j] != color? 1 : 0;
                }else{
                    value = board[i][j] == color? 1 : 0;
                }
                dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j] - dp[i][j] + value;
            }
        }
        for(int i=1;i<=n-k+1;i++){
            for(int j=1;j<=m-k+1;j++){
                count = Math.min(count, dp[i + k - 1][j + k - 1] - dp[i + k - 1][j - 1] - dp[i - 1][j + k - 1] + dp[i - 1][j - 1]);
            }
        }
        return count;
    }
}