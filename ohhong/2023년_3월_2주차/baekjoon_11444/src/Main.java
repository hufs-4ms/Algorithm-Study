import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long[][] matrix = new long[2][2];
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                if(i==1&&j==1){
                    matrix[i][j] = 0;
                }else{
                    matrix[i][j] = 1;
                }
            }
        }
        long[][] result = pow(matrix, n);
        System.out.print(result[1][0]);
        br.close();
    }
    public static long[][] pow(long[][] a, long b){
        if(b == 1L){
            return a;
        }
        long[][] m = pow(a, b/2);
        m = multi(m, m);
        if(b%2==1L){
            m = multi(m, a);
        }
        return m;
    }
    public static long[][] multi(long[][] a, long[][] b){
        long[][] arr = new long[2][2];
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<2;k++){
                    arr[i][j] += a[i][k]*b[k][j];
                    arr[i][j] %= 1000000007;
                }
            }
        }
        return arr;
    }
}