import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int start = 1;
        int end = arr[n-1]-arr[0];
        int result = 0;
        while(start<=end){
            int mid = (start+end)/2;
            int length = 0;
            int count = 1;

            for(int i=1;i<n;i++){
                length += arr[i]-arr[i-1];
                if(length>=mid){
                    count++;
                    length=0;
                }
            }
            if(count >=c){
                result = mid;
                start = mid+1;
            } else{
                end = mid-1;
            }
        }
        System.out.print(result);
    }
}