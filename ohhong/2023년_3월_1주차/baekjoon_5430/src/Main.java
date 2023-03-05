import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        for(int i=0;i<t;i++){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            boolean vector = true;
            boolean error = false;
            arr.clear();
            st = new StringTokenizer(str.substring(1, str.length()-1), "[],");
            for(int j=0;j<n;j++){
                arr.add(Integer.parseInt(st.nextToken()));
            }
            for(int j=0;j<p.length();j++){
                if(p.charAt(j) == 'R'){
                    if(vector){
                        vector = false;
                    }else {
                        vector = true;
                    }
                }else if(p.charAt(j) == 'D'){
                    if(arr.isEmpty()){
                        error = true;
                        break;
                    }
                    if(vector){
                        arr.removeFirst();
                        n--;
                    }else{
                        arr.removeLast();
                        n--;
                    }
                }
            }
            if(error){
                sb.append("error\n");
                continue;
            }
            sb.append("[");
            for(int j=0;j<n;j++){
                if(j == n-1){
                    sb.append(arr.poll());
                }else{
                    if(vector){
                        sb.append(arr.pollFirst()).append(",");
                    }else{
                        sb.append(arr.pollLast()).append(",");
                    }
                }
            }
            sb.append("]\n");
        }
        System.out.println(sb);
        br.close();
    }
}