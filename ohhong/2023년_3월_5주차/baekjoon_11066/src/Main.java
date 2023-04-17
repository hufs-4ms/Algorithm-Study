import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<t;i++){
            pq.clear();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<n;j++){
                pq.add(Long.parseLong(st.nextToken()));
            }
            long total = 0;
            while(true){
                long a = pq.poll();
                long b = pq.poll();
                long c = a+b;
                total += c;
                if (pq.isEmpty()) {
                    break;
                }
                pq.add(c);
            }
            sb.append(total).append("\n");
        }
        System.out.println(sb);
    }
}