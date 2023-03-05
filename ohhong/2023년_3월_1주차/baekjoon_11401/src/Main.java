import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    final static long p = 1000000007;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long up = fac(n);
        long down = fac(k)*fac(n-k)%p;
        System.out.print(up*part(down, p-2)%p);
        br.close();
    }
    public static long fac(long n){
        long r = 1;
        while(n>1){
            r *= n;
            r %= p;
            n--;
        }
        return r;
    }
    public static long part(long n, long k){
        long result = 1;
        while(k >0){
                if(k%2 == 1){
                    result *= n;
                    result %= p;
                }
                n = (n*n)%p;
                k /= 2;
        }
        return result;
    }
}