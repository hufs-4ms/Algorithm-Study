import java.util.*;
import java.io.*;
public class Main {

    static String word;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();

        int start = 0;
        int end = word.length()-1;
        int k = 0;
        int result = palindrome(start, end, k);
        if(result>3){
            System.out.print(-1);
        }else{
            System.out.print(result);
        }
    }
    public static int palindrome(int start, int end, int k){
        int num;
        if(start > end){
            return k;
        }
        if(word.charAt(start) == word.charAt(end)){
            num = palindrome(start+1, end-1, k);
        }else{
            if(k+1 > 3){
                return k+1;
            }
            int num1 = palindrome(start+1, end, k+1);
            int num2 = palindrome(start, end-1, k+1);
            int num3 = palindrome(start+1, end-1, k+2);
            num = Math.min(Math.min(num1, num2), num3);
        }
        return num;
    }
}
