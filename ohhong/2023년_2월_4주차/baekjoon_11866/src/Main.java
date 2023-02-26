import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            queue.add(i+1);
        }
        sb.append('<');
        while(true){
            for(int i=1;i<k;i++){
                queue.add(queue.poll());
            }
            sb.append(queue.poll());
            if(queue.isEmpty()){
                sb.append('>');
                break;
            }else{
                sb.append(", ");
            }
        }
        System.out.println(sb);
        br.close();
    }
}