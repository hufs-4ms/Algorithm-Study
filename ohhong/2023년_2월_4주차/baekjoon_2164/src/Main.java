import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            queue.offer(i+1);
        }
        while(queue.size()>1){
            queue.poll();
            int sum = queue.poll();
            queue.offer(sum);
        }
        System.out.println(queue.poll());
    }
}