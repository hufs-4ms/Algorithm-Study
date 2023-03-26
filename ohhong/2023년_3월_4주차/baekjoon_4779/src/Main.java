import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
            int n = Integer.parseInt(str);
            System.out.println(build(n));
        }
        br.close();
    }

    public static StringBuilder build(int n){
        StringBuilder sb = new StringBuilder();
        if(n == 0){
            return sb.append("-");
        }
        StringBuilder sb1 = build(n-1);
        sb.append(sb1);
        for(int i=0;i<Math.pow(3, n-1);i++){
            sb.append(" ");
        }
        sb.append(sb1);
        return sb;
    }
}