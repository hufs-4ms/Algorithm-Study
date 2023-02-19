import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        Stack<Integer> stack = new Stack<>();
        while(true){
            str = br.readLine();
            if(Objects.equals(str, ".")){
                break;
            }
            int sum = 0;
            stack.clear();
            for(int i=0;i<str.length();i++){
                if(str.charAt(i) == '('){
                    stack.push(1);
                }else if(str.charAt(i) == ')'){
                    if(stack.empty()){
                        sum++;
                        break;
                    }
                    if(stack.peek() == 1){
                        stack.pop();
                    }else{
                        sum++;
                        break;
                    }
                }else if(str.charAt(i) == '['){
                    stack.push(2);
                }else if(str.charAt(i) == ']'){
                    if(stack.empty()){
                        sum++;
                        break;
                    }
                    if(stack.peek() == 2){
                        stack.pop();
                    }else{
                        sum++;
                        break;
                    }
                }
            }
            if(stack.empty()&&sum==0){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
        br.close();
    }
}
