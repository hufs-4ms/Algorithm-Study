import java.io.*;
import java.util.*;
public class Main {
    static int arr[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = i;
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            reverseArray(j, k);
        }
        for(int i=1;i<=n;i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void reverseArray(int start, int end) {
        int temp;
        for (int i = start; i <= (start + end) / 2; i++) {
            temp = arr[i];
            arr[i] = arr[end - i + start];
            arr[end - i + start] = temp;
        }
    }
}