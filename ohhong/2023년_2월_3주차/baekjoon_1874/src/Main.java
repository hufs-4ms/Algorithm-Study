import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for(int i=0;i<n;i++){
            arr1[i] = i+1;
            arr2[i] = Integer.parseInt(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        int i1=0, i2=0;
        while (i1 != n+1 && i2 != n) {
            if(stack.empty()&&i1<n){
                stack.push(arr1[i1]);
                i1++;
                sb.append('+').append('\n');
            }else if (arr2[i2] == stack.peek()) {
                i2++;
                stack.pop();
                sb.append('-').append('\n');
            } else {
                if(i1==n){
                    System.out.println("NO");
                    System.exit(0);
                }
                stack.push(arr1[i1]);
                i1++;
                sb.append('+').append('\n');
            }
        }
        System.out.println(sb);
        br.close();
    }
}