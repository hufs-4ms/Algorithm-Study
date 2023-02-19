import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            if(Objects.equals(str, "push")){
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            }else if(Objects.equals(str, "pop")){
                if(stack.empty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.peek());
                    stack.pop();
                }
            }else if(Objects.equals(str, "size")){
                System.out.println(stack.size());
            }else if(Objects.equals(str, "empty")){
                if(stack.empty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else if(Objects.equals(str, "top")){
                if(stack.empty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.peek());
                }
            }
        }
        br.close();
    }
}