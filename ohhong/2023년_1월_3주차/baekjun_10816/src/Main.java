import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int sum;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++){
            sum = Integer.parseInt(st1.nextToken());
            if(map.containsKey(sum)){
                map.put(sum, map.get(sum)+1);
            }else{
                map.put(sum, 1);
            }
        }
        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        int m = Integer.parseInt(st2.nextToken());
        StringTokenizer st3 = new StringTokenizer(bf.readLine());
        for(int i=0;i<m;i++){
            sum = Integer.parseInt(st3.nextToken());
            bw.write(map.getOrDefault(sum, 0) + " ");
        }
        bf.close();
        bw.flush();
        bw.close();
    }
}