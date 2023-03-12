import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int a_n = Integer.parseInt(st.nextToken());
        int a_m = Integer.parseInt(st.nextToken());
        int[][] a = new int[a_n][a_m];
        for(int i=0;i<a_n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<a_m;j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        int b_n = Integer.parseInt(st.nextToken());
        int b_m = Integer.parseInt(st.nextToken());
        int[][] b = new int[b_n][b_m];
        for(int i=0;i<b_n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<b_m;j++){
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<a_n;i++){
            for(int j=0;j<b_m;j++){
                sb.append(multi(a, b, a_m, i, j)).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    public static int multi(int[][] a, int[][] b, int size, int index_a, int index_b){
        int total =0;
        for(int i=0;i<size;i++){
            total += a[index_a][i]*b[i][index_b];
        }
        return total;
    }
}