import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> queue = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int start = 0, end = 0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(Objects.equals(str, "push")){
                int sum = Integer.parseInt(st.nextToken());
                queue.add(sum);
                end++;
            }else if(Objects.equals(str, "pop")){
                if(start==end){
                    sb.append(-1).append('\n');
                }else{
                    sb.append(queue.get(start)).append('\n');
                    start++;
                }
            }else if(Objects.equals(str, "size")){
                sb.append(end-start).append('\n');
            }else if(Objects.equals(str, "empty")){
                if(start==end){
                    sb.append(1).append('\n');
                }else{
                    sb.append(0).append('\n');
                }
            }else if(Objects.equals(str, "front")){
                if(start==end){
                    sb.append(-1).append('\n');
                }else{
                    sb.append(queue.get(start)).append('\n');
                }
            }else if(Objects.equals(str, "back")){
                if(start==end){
                    sb.append(-1).append('\n');
                }else{
                    sb.append(queue.get(end-1)).append('\n');
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}