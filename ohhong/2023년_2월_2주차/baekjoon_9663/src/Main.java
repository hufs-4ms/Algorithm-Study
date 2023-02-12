import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;
public class Main {
    static int count =0;
    static int n;
    static int[] board = new int[15];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        nqueen(0);
        bw.write(count+"");
        br.close();
        bw.flush();
        bw.close();
    }
    public static boolean promising(int cdx){
        for(int i=0;i<cdx;i++){
            if(board[cdx]==board[i]||cdx-i==Math.abs(board[cdx]-board[i])){
                return false;
            }
        }
        return true;
    }
    public static void nqueen(int cdx){
        if(cdx == n){
            count++;
            return;
        }
        for(int i=0;i<n;i++){
            board[cdx] = i;
            if(promising(cdx)){
                nqueen(cdx+1);
            }
        }
    }

}