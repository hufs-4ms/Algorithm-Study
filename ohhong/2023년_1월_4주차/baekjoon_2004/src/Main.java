import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int total1 = fac1(n)-(fac1(n-k)+fac1(k));
        int total2 = fac2(n)-(fac2(n-k)+fac2(k));
        bw.write(Math.min(total1,total2)+"");
        br.close();
        bw.flush();
        bw.close();
    }

    public static int fac1(int num){
        int count = 0;
        while(num>=5){
            count += num/5;
            num/=5;
        }
        return count;
    }

    public static int fac2(int num){
        int count = 0;
        while(num>=2){
            count += num/2;
            num/=2;
        }
        return count;
    }
}