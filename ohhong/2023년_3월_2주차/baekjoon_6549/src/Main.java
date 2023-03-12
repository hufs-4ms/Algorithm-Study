import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    public static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            if(n == 0){
                break;
            }
            arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(getArea(0, n-1)).append("\n");
            arr = null;
        }
        System.out.print(sb);
        br.close();
    }
    public static long getArea(int start, int end){
        if(start == end){
            return arr[start];
        }
        int mid = (start+end)/2;
        long a = getArea(start, mid);
        long b = getArea(mid+1, end);
        long max = Math.max(a, b);
        max = Math.max(max, getC(start, end, mid));
        return max;
    }
    public static long getC(int start, int end, int mid){
        int a = mid;
        int b = mid;
        long length = arr[mid];
        long max = length;
        while(start<a&&b<end){
            if(arr[a-1] < arr[b+1]){
                b++;
                length = Math.min(length, arr[b]);
            }else{
                a--;
                length = Math.min(length, arr[a]);
            }
            max = Math.max(max, length*(b-a+1));
        }
        while(b<end){
            b++;
            length = Math.min(length, arr[b]);
            max = Math.max(max, length*(b-a+1));
        }

        while(a>start){
            a--;
            length = Math.min(length, arr[a]);
            max = Math.max(max, length*(b-a+1));
        }
        return max;
    }
}
