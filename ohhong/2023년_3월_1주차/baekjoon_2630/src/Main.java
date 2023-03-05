import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    static int blue = 0;
    static int white = 0;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        division(0,0,n);
        System.out.println(white);
        System.out.print(blue);
        br.readLine();
    }
    static void division(int row, int col, int size){
        if(check(row, col, size)){
            if(arr[row][col] == 0){
                white++;
            }else{
                blue++;
            }
            return;
        }
        int s = size/2;
        division(row,col,s);
        division(row+s, col, s);
        division(row, col+s, s);
        division(row+s, col+s, s);
    }
    static boolean check(int row, int col, int size){
        int color = arr[row][col];
        for(int i=row;i<row+size;i++){
            for(int j=col;j<col+size;j++){
                if(color != arr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}