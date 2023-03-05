import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    public static int a1=0, a2=0, a3=0;
    public static int[][] arr;
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
        System.out.println(a1);
        System.out.println(a2);
        System.out.print(a3);
        br.close();
    }
    public static void division(int row, int col, int size){
        if(check(row, col, size)){
            if(arr[row][col] == -1){
                a1++;
            }else if(arr[row][col] == 0){
                a2++;
            }else{
                a3++;
            }
            return;
        }
        int s = size/3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                division(row+(i*s), col+(j*s), s);
            }
        }
    }
    public static boolean check(int row, int col, int size) {
        int color = arr[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}