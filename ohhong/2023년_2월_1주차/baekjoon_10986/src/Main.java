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
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());
        int sum=0;
        for(int i=0;i<n;i++){
            sum = (sum + Integer.parseInt(st.nextToken()))%m;
            arr[sum]++;
        }
        long count = arr[0];
        for(int i=0;i<m;i++) {
            count +=(long) arr[i]*(arr[i]-1)/2;
        }
        bw.write(count+"");
        br.close();
        bw.flush();
        bw.close();
    }
}