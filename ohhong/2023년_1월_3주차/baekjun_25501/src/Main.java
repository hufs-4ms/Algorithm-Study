import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int t = Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++){
            StringTokenizer to = new StringTokenizer(bf.readLine());
            String s = to.nextToken();
            count = 0;
            System.out.print(isPalindrome(s) + " ");
            System.out.println(count);
        }
    }

    static int recursion(String s, int l, int r){
        count++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }

    static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
}