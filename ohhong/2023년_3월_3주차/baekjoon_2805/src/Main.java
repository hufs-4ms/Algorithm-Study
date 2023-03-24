import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        int max_length = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > max_length){
                max_length = arr[i];
            }
        }
        long start = 0;
        long end = max_length;
        while(start<= end){
            long mid = (start+end)/2;
            long count = 0;
            for(int i=0;i<n;i++){
                if(arr[i]>mid){
                    count += arr[i]-mid;
                }
            }
            if(count >= m){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        System.out.println(end);
        br.close();
    }
}