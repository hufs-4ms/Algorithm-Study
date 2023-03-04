import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    public static int[][] arr;
    public static StringBuilder sb;
    public static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        sb = new StringBuilder();
        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        division(0,0,n);
        System.out.print(sb);
        br.close();
    }
    public static void division(int row, int col, int size){
        if(check(row, col, size)){
            if(size == n){
                sb.append("(");
            }
            if(arr[row][col] == 1){
                sb.append(1);
            }else{
                sb.append(0);
            }
            if(size == n){
                sb.append(")");
            }
            return;
        }
        int s = size/2;
        sb.append("(");
        division(row, col, s);
        division(row, col+s, s);
        division(row+s, col, s);
        division(row+s, col+s, s);
        sb.append(")");
    }
    public static boolean check(int row, int col, int size){
        int color = arr[row][col];
        for(int i=row;i<row+size;i++){
            for(int j=col;j<col+size;j++){
                if(arr[i][j] != color){
                    return false;
                }
            }
        }
        return true;
    }
}