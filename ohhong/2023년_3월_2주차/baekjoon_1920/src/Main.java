import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<m;i++){
            int num = Integer.parseInt(st.nextToken());
            if(search(arr, num)){
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
    public static boolean search(int[] arr, int value){
        int low = 0;
        int high = arr.length-1;
        int mid;
        while(low<=high){
            mid = (low+high)/2;
            if(arr[mid]==value){
                return true;
            }else if(arr[mid]>value){
                high = mid-1;
            }else if(arr[mid]<value){
                low = mid+1;
            }
        }
        return false;
    }
}