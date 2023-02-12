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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i=n-1;i>=0;i--){
            if(arr[i]<=k){
                count+=(k/arr[i]);
                k = k%arr[i];
            }
        }
        bw.write(count + "");
        br.close();
        bw.flush();
        bw.close();
    }
}