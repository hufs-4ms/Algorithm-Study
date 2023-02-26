import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        long total = 0;
        for(int i=0;i<k;i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                total -= stack.peek();
                stack.pop();
            }else{
                total += num;
                stack.push(num);
            }
        }
        System.out.println(total);
        br.close();
    }
}