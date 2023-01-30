import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    static int[][] dp = new int[31][31];
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(bf.readLine());
        for(int i=0;i<t;i++){
            st = new StringTokenizer(bf.readLine());
            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int total = fac(n, k);

            bw.write(total + "\n");
        }
        bf.close();
        bw.flush();
        bw.close();
    }

    public static int fac(int a, int b){
        if(dp[a][b]>0){
            return dp[a][b];
        }
        if(a==b||b==0){
            return dp[a][b] = 1;
        }
        return dp[a][b] = (fac(a-1,b-1)+fac(a-1,b));
    }
}