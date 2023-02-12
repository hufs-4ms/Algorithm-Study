import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.MAX_VALUE;
        StringTokenizer st1 = new StringTokenizer(br.readLine(), "-");
        while(st1.hasMoreTokens()){
            int num = 0;
            StringTokenizer st2 = new StringTokenizer(st1.nextToken(), "+");
            while(st2.hasMoreTokens()){
                num += Integer.parseInt(st2.nextToken());
            }
            if(sum == Integer.MAX_VALUE){
                sum = num;
            }else{
                sum -= num;
            }
        }
        System.out.println(sum);
        br.close();
    }
}