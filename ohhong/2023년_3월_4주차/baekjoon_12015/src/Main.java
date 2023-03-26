import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] LIS = new int[n];

        LIS[0] = arr[0];
        int lengthOfLIS = 1;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            if (LIS[lengthOfLIS - 1] < key) {
                lengthOfLIS++;
                LIS[lengthOfLIS - 1] = key;
            }
            else {
                int start = 0;
                int end = lengthOfLIS;
                while (start < end) {
                    int mid = (start + end) >>> 1;
                    if(LIS[mid] < key) {
                        start = mid + 1;
                    }
                    else {
                        end = mid;
                    }
                }
                LIS[start] = key;
            }
        }
        System.out.println(lengthOfLIS);
        br.close();
    }
}