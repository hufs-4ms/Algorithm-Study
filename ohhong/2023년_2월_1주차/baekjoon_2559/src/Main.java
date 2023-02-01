import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        int sum, max;
        for(int i=1;i<=n;i++){
            sum = Integer.parseInt(st.nextToken());
            arr[i] = arr[i-1]+sum;
        }
        max = arr[k];
        for(int i=k+1;i<=n;i++){
            sum = arr[i] - arr[i-k];
            if(max < sum){
                max = sum;
            }
        }
        bw.write(max + "");
        br.close();
        bw.flush();
        bw.close();
    }
}