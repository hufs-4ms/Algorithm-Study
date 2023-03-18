import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static int[][] arr;
    public static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        arr = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken())%1000;
            }
        }
        int[][] result = pow(arr, b);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    public static int[][] pow(int[][] a, long b){
        if(b == 1L){
            return a;
        }
        int[][] arr = pow(a,b/2);
        arr = multi(arr,arr);

        if(b%2==1l){
            arr = multi(arr,a);
        }
        return arr;
    }
    public static int[][] multi(int[][] a, int[][] b){
        int[][] arr = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    arr[i][j] += a[i][k]*b[k][j];
                    arr[i][j] %= 1000;
                }
            }
        }
        return arr;
    }
}