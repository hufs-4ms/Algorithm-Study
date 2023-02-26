import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] length = new int[n-1];
        int[] cost = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n-1;i++){
            length[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        long total=0;
        long min = cost[0];
        for(int i=0;i<n-1;i++){
            if(cost[i]<min){
                min = cost[i];
            }
            total += min*length[i];
        }
        System.out.println(total);
        br.close();
    }
}