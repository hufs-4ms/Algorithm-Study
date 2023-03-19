import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        long start = 1;
        long end = (long) n *n;
        long result = 0;
        while(start <= end){
            long mid = (start + end)/2;
            long count = 0;
            for(int i=1;i<n+1;i++){
                count += Math.min(mid/i, n);
            }
            if(count < k){
                start = mid+1;
            }else{
                result = mid;
                end = mid-1;
            }
        }
        System.out.println(result);
        br.close();
    }
}