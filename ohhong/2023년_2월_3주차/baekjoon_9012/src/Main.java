import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String str;
        for(int i=0;i<t;i++){
            str = br.readLine();
            int s = 0;
            for(int j=0;j<str.length();j++){
                if(str.charAt(j) == '('){
                    s++;
                }else if(str.charAt(j) == ')'){
                    s--;
                }
                if(s<0){
                    break;
                }
            }
            if(s==0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        br.close();
    }
}