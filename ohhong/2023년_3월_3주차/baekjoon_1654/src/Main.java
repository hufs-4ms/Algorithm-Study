import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        int max_length = Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] > max_length){
                max_length = arr[i];
            }
        }
        long start = 0;
        long end = max_length;
        while(start<=end){
            long mid = (start+end)/2;
            if(mid == 0){
                mid = 1;
            }
            int count = 0;
            for(int i=0;i<k;i++){
                count += arr[i]/mid;
            }
            if(count >= n){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        System.out.println(end);
        br.close();
    }
}