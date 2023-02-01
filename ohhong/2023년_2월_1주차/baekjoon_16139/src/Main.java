import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for(int i=1;i<s.length();i++){
            int i1 = s.lastIndexOf(s.charAt(i), i-1);
            if(i1 >=0){
                dp[i] = dp[i1]+1;
            }else{
                dp[i] = 1;
            }
        }

        for(int i=0;i<q;i++){
            st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int num1;
            if(s.lastIndexOf(c, end)>=0){
                num1 = dp[s.lastIndexOf(c, end)];
            }else{
                num1 = 0;
            }
            int num2;
            start--;
            if(s.lastIndexOf(c, start)>=0){
                num2 = dp[s.lastIndexOf(c, start)];
            }else{
                num2 = 0;
            }
            bw.write(num1-num2+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}