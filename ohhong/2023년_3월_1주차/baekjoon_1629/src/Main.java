import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    public static long c;
    public static long a;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        System.out.print(division(b));
        br.close();
    }
    public static long division(int count){
        if(count == 1){
            return a%c;
        }
        long sum = division(count/2);
        if(count%2 == 1){
            return (sum*sum%c)*a%c;
        }
        return sum*sum%c;
    }
}